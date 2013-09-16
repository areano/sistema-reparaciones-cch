package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class GarantiaDAOImpl extends GenericDAOImpl<Garantia> {
	private static GarantiaDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static GarantiaDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new GarantiaDAOImpl();
		} 
		return instancia;
	}

	public Garantia findByNroGarantia(int nroGarantia) {
		Session session = sf.openSession();
		String hql = "from Garantia g where g.nroGarantia = :nroGarantia";
		Query query = session.createQuery(hql);
		query.setParameter("nroGarantia", nroGarantia);
		Garantia retorno =  (Garantia)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Garantia> findAll() throws DataAccessLayerException{
        return super.findAll(Garantia.class);
    }
	
}
