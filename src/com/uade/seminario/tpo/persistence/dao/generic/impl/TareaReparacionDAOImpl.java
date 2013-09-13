package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class TareaReparacionDAOImpl extends GenericDAOImpl<TareaReparacion> {
	private static TareaReparacionDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static TareaReparacionDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TareaReparacionDAOImpl();
		} 
		return instancia;
	}

	public TareaReparacion findByNroSerie(int nroItemReparacion) {
		Session session = sf.openSession();
		String hql = "from TareaReparacion t where t.nroItemReparacion = :nroItemReparacion";
		Query query = session.createQuery(hql);
		query.setParameter("nroItemReparacion", nroItemReparacion);
		TareaReparacion retorno =  (TareaReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<TareaReparacion> findAll() throws DataAccessLayerException{
        return super.findAll(TareaReparacion.class);
    }
//	public List<TareaReparacion> todasLasTareas() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "from TareaReparacion";
//		Query query = session.createQuery(hql);
//		List<TareaReparacion> retorno =  query.list();
//		session.close();
//		return retorno;
//	}	
	
}
