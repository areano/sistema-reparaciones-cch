package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.exceptions.DataAccessLayerException;
import com.uade.seminario.tpo.model.Equipo;
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
		String hql = "from OrdenReparacion o where o.nroOrden = :nroOrden";
		Query query = session.createQuery(hql);
		query.setParameter("nroOrden", nroOrden);
		OrdenReparacion retorno =  (OrdenReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}
    public List<OrdenReparacion> findAll() throws DataAccessLayerException{
        return super.findAll(OrdenReparacion.class);
    }

	public OrdenReparacion buscarEquipoxOrdenRepAConfirmar(Equipo equipo) {
		Session session = sf.openSession();
		String hql = "from OrdenReparacion o inner join o.equipo e where e =: equipo and " +
				"o.estado := estado";
		Query query = session.createQuery(hql);
		query.setParameter("equipo", equipo);
		query.setParameter("estado", new String("A reparar"));
		OrdenReparacion retorno =  (OrdenReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}

	public OrdenReparacion buscarOrdenConEquipoARepararView(Equipo equipo) {
		Session session = sf.openSession();
		String hql = "select o from OrdenReparacion o inner join o.equipo e where e =:equipo and e.estado!='Entregado'";
		Query query = session.createQuery(hql);
		query.setParameter("equipo", equipo);
		OrdenReparacion retorno =  (OrdenReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}

	public OrdenReparacion buscarOrdenReparacionPrioridad() {
		Session session = sf.openSession();
		String hql = "from OrdenReparacion o  where o.estado not in ('A confirmar', 'A presupuestar') order by o.prioridad desc";
		Query query = session.createQuery(hql).setMaxResults(1);
		
		OrdenReparacion retorno =  (OrdenReparacion)query.uniqueResult();
		session.close();
		return retorno;
	}

	public List<OrdenReparacion> ordenesPorFecha(Date desde, Date hasta) {
		Session session = sf.openSession();
		String hql = "from OrdenReparacion o " +
				"where (o.fecha >=  =:desde) and (o.fecha <= =:hasta)";
		Query query = session.createQuery(hql);
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		List<OrdenReparacion>  retorno =  (List<OrdenReparacion>)query.list();
		session.close();
		return retorno;
	}

}
