package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.ClienteId;
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
		Session session = sf.openSession();
		ClienteId cID = new ClienteId(nroDoc,tipoDoc);
		String hql = "from Cliente p where p.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", cID);
		//query.setParameter("tipoDoc", tipoDoc);	
		Cliente retorno =  (Cliente)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<Cliente> findAll() throws DataAccessLayerException{
        return super.findAll(Cliente.class);
    }
//	public List<Cliente> todosLosClientes() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		String hql = "from Cliente";
//		Query query = session.createQuery(hql);
//		List<Cliente> retorno =  query.list();
//		session.close();
//		return retorno;
//	}	

}
