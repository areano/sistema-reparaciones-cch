package com.uade.seminario.tpo.persistence.dao.generic;

import java.util.List;

public interface GenericDAO<T> {

	void save(T entidad);
	void delete(T entity);
	List<T> findAll(@SuppressWarnings("rawtypes") Class clazz);
	void update(T entidad);
	void merge(T entidad);
	
	
}
