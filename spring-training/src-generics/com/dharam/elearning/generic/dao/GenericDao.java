package com.dharam.elearning.generic.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dharam.elearning.generic.bean.GenericBean;
import com.dharam.elearning.generic.util.GenericUtil;
import com.dharam.elearning.generic.util.Utility;

@Repository("genericDao")
@SuppressWarnings("unchecked")
public class GenericDao<T extends GenericBean> implements IGenericDao<T>
{
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private GenericUtil<T> util;

	@Autowired
	private Utility utility;

	public Class<T> getTypeParameterClass()
	{
		Type type = getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) type;
		return (Class<T>) paramType.getActualTypeArguments()[0];
	}

	public T getInstance() throws InstantiationException, IllegalAccessException
	{
		T object = this.getTypeParameterClass().newInstance();
		return object;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public Session getSession()
	{
		Session session;
		try
		{
			session = sessionFactory.getCurrentSession();
		}
		catch (Exception e)
		{
			log.info("- No Hibernate Session Found, Creating Session -");
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T add(T object)
	{
		util.timestampAdd(object);
		getSession().save(object);
		return object;
	}

	public String like(String string)
	{
		if (StringUtils.isNotBlank(string))
			return "%" + string + "%";
		else
			return "";
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> add(List<T> objects)
	{
		util.timestampAdd(objects);

		if (CollectionUtils.isNotEmpty(objects))
			for (int i = 0; i < objects.size(); i++)
			{
				getSession().saveOrUpdate(objects.get(i));
				if (i % 50 == 0)
				{
					getSession().flush();
					getSession().clear();
				}
			}
		return objects;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T update(T object)
	{
		try
		{
			util.timestampUpdate(object);
			getSession().saveOrUpdate(object);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> update(List<T> objects)
	{
		util.timestampUpdate(objects);

		if (CollectionUtils.isNotEmpty(objects))
			for (int i = 0; i < objects.size(); i++)
			{
				getSession().saveOrUpdate(objects.get(i));
				if (i % 50 == 0)
				{
					getSession().flush();
					getSession().clear();
				}
			}

		return objects;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T delete(T object)
	{
		util.timestampDelete(object);
		getSession().update(object);
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> delete(List<T> objects)
	{
		util.timestampDelete(objects);

		if (CollectionUtils.isNotEmpty(objects))
			for (int i = 0; i < objects.size(); i++)
			{
				getSession().saveOrUpdate(objects.get(i));
				if (i % 50 == 0)
				{
					getSession().flush();
					getSession().clear();
				}
			}
		return objects;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<T> list()
	{
		List<T> objects = new ArrayList<T>(0);
		try
		{
			Query query = getSession().createQuery("from " + getInstance().getClass().getSimpleName() + " where deleteFlag='F' order by id desc");
			objects = query.list();
		}
		catch (Exception e)
		{
			utility.logException(e);
			e.printStackTrace();
		}
		return objects;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T retrieveById(Long id)
	{
		T object = null;
		try
		{
			Query query = getSession().createQuery("from " + getInstance().getClass().getSimpleName() + " where deleteFlag='F' AND id = :id");
			query.setParameter("id", id);
			object = (T) query.uniqueResult();
		}
		catch (Exception e)
		{
			utility.logException(e);
		}
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<T> retrieveByIds(List<Long> ids)
	{
		List<T> objects = null;
		try
		{
			Query query = getSession().createQuery("from " + getInstance().getClass().getSimpleName() + " where deleteFlag='F' AND id IN (:id)");
			query.setParameterList("id", ids);
			objects = (List<T>) query.list();
		}
		catch (Exception e)
		{
			utility.logException(e);
		}
		return objects;
	}

	public Map<String, String> propertyToColumMap()
	{
		Map<String, String> propertyColumnMap = new HashMap<String, String>();
		try
		{
			ClassMetadata classMetadata = sessionFactory.getClassMetadata(getInstance().getClass());

			SingleTableEntityPersister singleTableEntityPersister = (SingleTableEntityPersister) classMetadata;

			String[] propertyNames = classMetadata.getPropertyNames();

			List<String> properties = new ArrayList<String>(Arrays.asList(propertyNames));
			properties.add(classMetadata.getIdentifierPropertyName());

			if (CollectionUtils.isNotEmpty(properties))
				for (int i = 0; i < properties.size(); i++)
					propertyColumnMap.put(properties.get(i), singleTableEntityPersister.getPropertyColumnNames(properties.get(i))[0]);
		}
		catch (Exception e)
		{
			log.error("- Property To Column Conversion Failed -");
			utility.logException(e);
			e.printStackTrace();
		}
		return propertyColumnMap;
	}

}
