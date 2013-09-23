package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.OrdenDeReparacionDAOImpl;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.exceptions.NoHayOrdenesException;
import com.uade.seminario.tpo.exceptions.OrdenNoDisponibleException;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.OrdenReparacion;

import java.sql.Date;
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
	public void save(OrdenReparacion entidad){
		dao.save(entidad);
	}
	public OrdenReparacion findByNroOrden(int nroOrden){
		return dao.findByNroOrden(nroOrden);
	}
	public List<OrdenReparacion> todasLasOrdenes(){
		return dao.findAll();
	}
	public void update(OrdenReparacion entidad){
		dao.update(entidad);
	}
	public void merge(OrdenReparacion entidad) {
		dao.merge(entidad);
		
	}
	public OrdenReparacion buscarEquipoxOrdenRepAConfirmar(Equipo equipo) {
		return dao.buscarEquipoxOrdenRepAConfirmar(equipo);
	}
	public OrdenReparacion buscarOrdenConEquipoARepararView(Equipo equipo) {
		return dao.buscarOrdenConEquipoARepararView(equipo);
	}
	public OrdenReparacion buscarOrdenReparacion(int nroReparacion) {
		return dao.findByNroOrden(nroReparacion);
	}
	public OrdenReparacion buscarOrdenReparacionPrioridad() throws OrdenNoDisponibleException{
		OrdenReparacion orden = dao.buscarOrdenReparacionPrioridad();
		if (orden == null){
			throw new OrdenNoDisponibleException();
		}
		return orden;
	}
	public List<OrdenReparacion> ordenesPorFecha(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return dao.ordenesPorFecha(desde, hasta);
	}
	
}
