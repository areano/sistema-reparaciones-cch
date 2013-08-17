package com.uade.seminario.tpo.persistence.dao.generic.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente>{
	private static ClienteDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static ClienteDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAOImpl();
		} 
		return instancia;
	}

	public Cliente findByDNI(String nroDoc, String tipoDoc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Cliente p where p.nroDoc = :nroDoc and p.tipoDoc = :tipoDoc";
		Query query = session.createQuery(hql);
		query.setParameter("nroDoc", nroDoc);
		query.setParameter("tipoDoc", tipoDoc);		
		return (Cliente)query.uniqueResult();
	}

}
