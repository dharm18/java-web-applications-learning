package com.dharam.elearning.generic.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dharam.elearning.generic.bean.GenericBean;

public interface IGenericDao<T extends GenericBean>
{
    Session getSession();
    
    SessionFactory getSessionFactory();
    
    T add(T object);
    
    List<T> add(List<T> objects);
    
    T update(T object);
    
    List<T> update(List<T> objects);
    
    T delete(T object);
    
    List<T> delete(List<T> objects);
    
    List<T> list();
    
    Map<String, String> propertyToColumMap();
    
    T retrieveById(Long id);
    
    List<T> retrieveByIds(List<Long> ids);
}
