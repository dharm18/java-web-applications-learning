package com.dharam.elearning.generic.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dharam.elearning.generic.bean.GenericBean;

@Component
@SuppressWarnings({ "hiding", "unchecked" })
public class GenericUtil<T extends GenericBean>
{
	Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private Utility utility;

	public <T extends GenericBean> T timestampAdd(T object)
	{
		object.setCreatedOn(new Timestamp(new Date().getTime()));
		object.setModifiedOn(new Timestamp(new Date().getTime()));
		object.setDeleteFlag("F");
		return object;
	}

	public <T extends GenericBean> List<T> timestampAdd(List<T> objects)
	{
		if (CollectionUtils.isNotEmpty(objects))
		{
			for (int i = 0; i < objects.size(); i++)
			{
				objects.get(i).setCreatedOn(new Timestamp(new Date().getTime()));
				objects.get(i).setModifiedOn(new Timestamp(new Date().getTime()));
				objects.get(i).setDeleteFlag("F");
			}
		}

		return objects;
	}

	public <T extends GenericBean> T timestampUpdate(T object)
	{
		object.setModifiedOn(new Timestamp(new Date().getTime()));
		object.setDeleteFlag("F");
		return object;
	}

	public <T extends GenericBean> List<T> timestampUpdate(List<T> objects)
	{
		if (CollectionUtils.isNotEmpty(objects))
			for (int i = 0; i < objects.size(); i++)
			{
				objects.get(i).setModifiedOn(new Timestamp(new Date().getTime()));
				objects.get(i).setDeleteFlag("F");
			}
		return objects;
	}

	public <T extends GenericBean> T timestampDelete(T object)
	{
		object.setModifiedOn(new Timestamp(new Date().getTime()));
		object.setDeleteFlag("T");
		return object;
	}

	public <T extends GenericBean> List<T> timestampDelete(List<T> objects)
	{
		if (CollectionUtils.isNotEmpty(objects))
			for (int i = 0; i < objects.size(); i++)
			{
				objects.get(i).setModifiedOn(new Timestamp(new Date().getTime()));
				objects.get(i).setDeleteFlag("T");
			}
		return objects;
	}
}
