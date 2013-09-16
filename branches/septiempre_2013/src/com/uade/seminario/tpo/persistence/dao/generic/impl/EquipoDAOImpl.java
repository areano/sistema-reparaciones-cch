package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class EquipoDAOImpl extends GenericDAOImpl<Equipo> {
	private static EquipoDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static EquipoDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EquipoDAOImpl();
		} 
		return instancia;
	}

	public Equipo findByNroSerie(int nroSerie) {
		Session session = sf.openSession();
		String hql = "from Equipo e where e.nroSerie = :nroSerie";
		Query query = session.createQuery(hql);
		query.setParameter("nroSerie", nroSerie);
		Equipo retorno =  (Equipo)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Equipo> findAll() throws DataAccessLayerException{
        return super.findAll(Equipo.class);
    }

	public List<Equipo> existeElModeloEnUnEquipo(Modelo modelo) {
		Session session = sf.openSession();
		String hql = "from Equipo e inner join e.modelo m where m = :modelo";
		Query query = session.createQuery(hql);
		query.setParameter("modelo", modelo);
		List<Equipo> retorno =  (List)query.list();
		session.close();
		return retorno;
	}

	
}
