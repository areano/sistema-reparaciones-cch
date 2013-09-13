package com.uade.seminario.tpo.persistence.dao.generic;

import java.util.List;

public interface GenericDAO<T> {

	abstract void save(T entidad);
	abstract void delete(T entity);
	abstract List<T> findAll(@SuppressWarnings("rawtypes") Class clazz);
	abstract void update(T entidad);
	abstract void merge(T entidad);
	
	
}
