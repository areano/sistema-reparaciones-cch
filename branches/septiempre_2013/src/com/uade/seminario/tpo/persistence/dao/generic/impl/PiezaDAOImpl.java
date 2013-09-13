package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class PiezaDAOImpl extends GenericDAOImpl<Pieza> {
	private static PiezaDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static PiezaDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new PiezaDAOImpl();
		} 
		return instancia;
	}

	public Pieza findByNroSerie(int nroPieza) {
		Session session = sf.openSession();
		String hql = "from Pieza p where p.nroPieza = :nroPieza";
		Query query = session.createQuery(hql);
		query.setParameter("nroPieza", nroPieza);
		Pieza retorno =  (Pieza)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Pieza> findAll() throws DataAccessLayerException{
        return super.findAll(Pieza.class);
    }
//	public List<Pieza> todosLosModelos() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "from Pieza";
//		Query query = session.createQuery(hql);
//		List<Pieza> retorno =  query.list();
//		session.close();
//		return retorno;
//	}	
	
}
