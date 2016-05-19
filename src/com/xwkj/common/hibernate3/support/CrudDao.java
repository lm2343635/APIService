package com.xwkj.common.hibernate3.support;

import java.io.Serializable;

import java.util.List;

public interface CrudDao<T extends Serializable> {
	T get(String id);

	List<T> findAll();

	String save(T entity);

	void update(T entity);

	void delete(T entity);
	
	void delete(String id);
}
