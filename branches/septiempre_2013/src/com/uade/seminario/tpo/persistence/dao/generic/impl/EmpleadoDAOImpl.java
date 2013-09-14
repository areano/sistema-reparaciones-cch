package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
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
		Empleado retorno = (Empleado)query.uniqueResult();
		session.close();
		return retorno;
	}

	public Empleado findByLegajo(int legajo) {
		Session session = sf.openSession();
		String hql = "from empleado p where p.legajo = : legajo";
		Query query = session.createQuery(hql);
		query.setParameter("legajo", legajo);
		Empleado retorno = (Empleado)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Empleado> findAll() throws DataAccessLayerException{
        return super.findAll(Empleado.class);
    }


}
