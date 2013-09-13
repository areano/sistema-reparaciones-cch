package com.uade.seminario.tpo.persistence.dao.generic.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.persistence.dao.generic.GenericDAO;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@Override
	public void delete(T entity) {//tengo que cambiarlo para borrar pasando sólo el id.
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
//	public List<T> findAll(Class clazz) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query query = session.createQuery("from " +  clazz.getName());
//		List<T> lista =(List<T>)query.list();
//		session.close();
//		return lista;
//	}
    public List<T> findAll(Class clazz) {
        List<T> objects = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
        	session.close();
        }
        return objects;
    }

    protected void handleException(HibernateException e) throws DataAccessLayerException {
        throw new DataAccessLayerException(e);
    }

	@Override
	public void save(T entidad) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.persist(entidad);

		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void update(T entidad){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(entidad);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void merge(T entidad){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(entidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	

}
