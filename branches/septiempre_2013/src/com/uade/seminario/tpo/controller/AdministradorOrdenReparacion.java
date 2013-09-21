package com.uade.seminario.tpo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import com.uade.seminario.tpo.exceptions.NoHayOrdenesException;
import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.service.OrdenDeReparacionDataService;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;

public class AdministradorOrdenReparacion {
	private static AdministradorOrdenReparacion instancia;
	private OrdenDeReparacionDataService ordenReparacionDataService; 
	private AdministradorOrdenReparacion(){
		ordenReparacionDataService = OrdenDeReparacionDataService.getInstance();
	}
	protected static AdministradorOrdenReparacion getInstancia(){
		if(instancia==null)
			instancia=new AdministradorOrdenReparacion();
		return instancia;
	}
	public OrdenReparacion fromDTOtoClassTransformer(OrdenReparacionView orv){		
		OrdenReparacion or = new OrdenReparacion();
		or.setEquipo(AdministradorEquipo.getInstancia().fromDTOtoClassTransformer(orv.getEquipo()));
		or.setDescripcionFallas(orv.getDescripcionFallas());
		or.setEstado(orv.getEstado());
		or.setEstaEnGarantiaFisica(orv.isEstaEnGarantiaFisica());
		or.setFecha(orv.getFecha());
		for ( TareaReparacionView trv : orv.getItemsReparacion()){
			or.agregarItemReparacion(AdministradorTareaReparacion.getInstancia().fromDTOtoClassTransformer(trv));
		}
		or.setNroOrden(orv.getNroOrden());
		or.setPrioridad(orv.getPrioridad());
		or.setRepararDeTodosModos(orv.isRepararDeTodosModos());
		return or ;		

	}
	protected void modificarOrdenReparacion(OrdenReparacionView orden ){
		ordenReparacionDataService.merge(fromDTOtoClassTransformer(orden));
		
	}
	protected void confirmarOrdenReparacion(OrdenReparacionView orden ){
		OrdenReparacion ordenReparacion = new OrdenReparacion();
		Equipo equipo = AdministradorEquipo.getInstancia().
				buscarEquipo(orden.getEquipo().getNroSerie());
		List<TareaReparacion> tareasReparacion = new ArrayList<TareaReparacion>();
		List<Pieza> piezasReparacion = new ArrayList<Pieza>();
		Pieza piezaToAdd;
		TareaReparacion tareaReparacion;
		for(TareaReparacionView tarea:orden.getItemsReparacion()){
			tareaReparacion = new TareaReparacion();
			
			tareaReparacion.setDetalle(tarea.getDetalle());
			tareaReparacion.setEstado(tarea.getEstado());
			
			for(PiezaView pieza: tarea.getPiezas()){
				piezaToAdd = AdministradorPieza.getInstancia().buscarPieza(pieza.getNroPieza());
				piezasReparacion.add(piezaToAdd);
			}
			tareaReparacion.setPiezas(piezasReparacion);
			tareasReparacion.add(tareaReparacion);			
		}
		
		ordenReparacion.setDescripcionFallas(orden.getDescripcionFallas());
		ordenReparacion.setEstado(orden.getEstado());
		ordenReparacion.setEstaEnGarantiaFisica(orden.isEstaEnGarantiaFisica());
		ordenReparacion.setFecha(orden.getFecha());
		ordenReparacion.setPrioridad(orden.getPrioridad());
		ordenReparacion.setRepararDeTodosModos(orden.isRepararDeTodosModos());
		ordenReparacion.setEquipo(equipo);
		ordenReparacion.setItemsReparacion(tareasReparacion);
		
	}
	protected  OrdenReparacion buscarEquipoxOrdenRepAConfirmar(Equipo equipo){
		return ordenReparacionDataService.buscarEquipoxOrdenRepAConfirmar(equipo);
	}
	protected OrdenReparacionView buscarOrdenConEquipoARepararView(Equipo equipo) {
		return ordenReparacionDataService.buscarOrdenConEquipoARepararView(equipo).getView();
	}
	protected OrdenReparacion buscarOrdenReparacion(int nroReparacion) {
		return ordenReparacionDataService.buscarOrdenReparacion(nroReparacion);
	}
	protected OrdenReparacion buscarOrdenReparacionPrioridad() throws NoHayOrdenesException{ 
		return ordenReparacionDataService.buscarOrdenReparacionPrioridad();
	}
	protected OrdenReparacionView asignarSiguienteOrdenReparacion(Empleado empleado) 
			throws NoHayOrdenesException{
		OrdenReparacion orden;
		orden =  empleado.siguienteTarea();
		if(orden==null)
		{
			orden = buscarOrdenReparacionPrioridad();
			empleado.addAReparar(orden);
		}
		
		return orden.getView();
	}
	protected List<TareaReparacionView> listarTareas(int nroReparacion){
		return AdministradorOrdenReparacion.getInstancia().buscarOrdenReparacion(nroReparacion).
				getView().getItemsReparacion();
	}
	protected List<OrdenReparacionView> ordenesPorFecha(Date desde, Date hasta) {
		List<OrdenReparacionView> listaOrdenes = new ArrayList<OrdenReparacionView>();
		List <OrdenReparacion> ordenes = ordenReparacionDataService.ordenesPorFecha(desde, hasta);
		for (OrdenReparacion ordenReparacion : ordenes) {
			listaOrdenes.add(ordenReparacion.getView());
		}
		return listaOrdenes;
	}


	
}
