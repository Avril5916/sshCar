package com.avril.util;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;


public interface BaseDao<T,PK extends Serializable> {
	public T getById(PK pk);
	public void insert(T t);
	public void update(T t);
	public void delete(T t);
	public void deleteById(PK pk);
	public Page pageHQL(String projection,String table ,String condition,int pageIndex);
	public Page pageCriteria(DetachedCriteria criteria,int pageIndex);
}


