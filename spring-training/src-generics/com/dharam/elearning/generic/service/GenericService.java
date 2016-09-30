package com.dharam.elearning.generic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dharam.elearning.generic.bean.GenericBean;
import com.dharam.elearning.generic.dao.IGenericDao;

@Service
public class GenericService<T extends GenericBean> implements IGenericService<T>
{
	@Autowired
	private IGenericDao<T> genericDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T add(T object)
	{
		return genericDao.add(object);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> add(List<T> objects)
	{
		return genericDao.add(objects);
	}

	@Transactional
	public T retrieveById(Long id)
	{
		return genericDao.retrieveById(id);
	}

	public List<T> retrieveByIds(List<Long> ids)
	{
		return genericDao.retrieveByIds(ids);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T update(T object)
	{
		return genericDao.update(object);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> update(List<T> objects)
	{
		return genericDao.update(objects);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public T delete(T object)
	{
		return genericDao.delete(object);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<T> delete(List<T> objects)
	{
		return genericDao.delete(objects);
	}

	@Transactional
	public List<T> list()
	{
		return genericDao.list();
	}

}
