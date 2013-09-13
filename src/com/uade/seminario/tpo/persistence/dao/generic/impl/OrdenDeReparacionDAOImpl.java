package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class OrdenDeReparacionDAOImpl extends GenericDAOImpl<OrdenReparacion>{
	private static OrdenDeReparacionDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static OrdenDeReparacionDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new OrdenDeReparacionDAOImpl();
		} 
		return instancia;
	}

	public OrdenReparacion findByNroOrden(int nroOrden) {
		Session session = sf.openSession();
		String hql = "from OrdenReparacion o where o.nroOrden := nroOrden";
		Query query = session.createQuery(hql);
		query.setParameter("nroOrden", nroOrden);
		OrdenReparacion retorno =  (OrdenReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<OrdenReparacion> findAll() throws DataAccessLayerException{
        return super.findAll(OrdenReparacion.class);
    }
//	public List<OrdenReparacion> todasLasOrdenReparacion() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "from OrdenReparacion";
//		Query query = session.createQuery(hql);
//		List<OrdenReparacion> retorno =  query.list();
//		session.close();
//		return retorno;
//	}	

}
