package com.dharam.elearning.generic.service;

import java.util.List;

import com.dharam.elearning.generic.bean.GenericBean;

public interface IGenericService<T extends GenericBean>
{
    T add(T object);
    
    List<T> add(List<T> objects);
    
    T update(T object);
    
    List<T> update(List<T> objects);
    
    T delete(T object);
    
    List<T> delete(List<T> objects);
    
    List<T> list();
    
    T retrieveById(Long id);
    
    List<T> retrieveByIds(List<Long> ids);
}
