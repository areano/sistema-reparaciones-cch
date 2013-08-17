package com.uade.seminario.tpo.persistence.dao.generic.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class EmpleadoDAOImpl extends GenericDAOImpl<Empleado>{
	private static EmpleadoDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static EmpleadoDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAOImpl();
		} 
		return instancia;
	}

	public Empleado findByDNI(String nroDoc, String tipoDoc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from empleado p where p.nroDoc = :nroDoc and p.tipoDoc = tipoDoc";
		Query query = session.createQuery(hql);
		query.setParameter("nroDoc", nroDoc);
		query.setParameter("tipoDoc", tipoDoc);		
		return (Empleado)query.uniqueResult();
	}

	public Empleado findByLegajo(String legajo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from empleado p where p.legajo = : legajo";
		Query query = session.createQuery(hql);
		query.setParameter("legajo", legajo);
		return (Empleado)query.uniqueResult();
	}

}
