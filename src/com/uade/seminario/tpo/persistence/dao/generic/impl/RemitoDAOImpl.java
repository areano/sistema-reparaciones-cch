package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Remito;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class RemitoDAOImpl extends GenericDAOImpl<Remito> {
	private static RemitoDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static RemitoDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new RemitoDAOImpl();
		} 
		return instancia;
	}

	public Remito findByNroRemito(int nroRemito) {
		Session session =sf.openSession();
		String hql = "from Remito m where m.nroRemito = :nroRemito";
		Query query = session.createQuery(hql);
		query.setParameter("nroRemito", nroRemito);
		Remito retorno =  (Remito)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Remito> findAll() throws DataAccessLayerException{
        return super.findAll(Remito.class);
    }
//	public List<Remito> todosLosModelos() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "from Remito";
//		Query query = session.createQuery(hql);
//		List<Remito> retorno =  query.list();
//		session.close();
//		return retorno;
//	}	
	
}
