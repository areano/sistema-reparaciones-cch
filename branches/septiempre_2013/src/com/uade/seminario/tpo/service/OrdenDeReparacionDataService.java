package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.OrdenDeReparacionDAOImpl;
import com.uade.seminario.tpo.model.OrdenReparacion;
import java.util.List;
public class OrdenDeReparacionDataService {
	private static OrdenDeReparacionDAOImpl dao;
	private static OrdenDeReparacionDataService cs=null;
	static {
		dao = OrdenDeReparacionDAOImpl.getInstancia();
	}
	private OrdenDeReparacionDataService(){
		
	}
	public static OrdenDeReparacionDataService getInstance(){
		if (cs==null){
			cs =  new OrdenDeReparacionDataService();
		}
		return cs;
	}
	public OrdenReparacion findByNroOrden(int nroOrden){
		return dao.findByNroOrden(nroOrden);
	}
	public List<OrdenReparacion> todasLasOrdenes(){
		return dao.findAll();
	}
	
}
