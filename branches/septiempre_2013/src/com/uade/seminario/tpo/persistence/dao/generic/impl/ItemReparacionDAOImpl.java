package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.ItemReparacion;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;

public class ItemReparacionDAOImpl extends GenericDAOImpl<ItemReparacion> {
	private static ItemReparacionDAOImpl instancia = null;
	private static SessionFactory sf = null;
	public static ItemReparacionDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemReparacionDAOImpl();
		} 
		return instancia;
	}

	public ItemReparacion findByNroTareaYPieza(int nroTarea, int nroPieza) {
		Session session = sf.openSession();
		String hql = "from ItemReparacion i inner join i.pieza p  where p.nroPieza = :nroPieza and i.nroItemReparacion = :nroTarea ";
		Query query = session.createQuery(hql);
		query.setParameter("nroTarea", nroTarea);
		query.setParameter("nroPieza",nroPieza);
		ItemReparacion retorno =  (ItemReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}
    
	public List<ItemReparacion> findAll() throws DataAccessLayerException{
        return super.findAll(ItemReparacion.class);
    }

	public ItemReparacion findByNroSerie(int nroSerie) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
