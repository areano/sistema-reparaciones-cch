package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.TareaReparacion;
import com.uade.seminario.tpo.service.TareaReparacionDataService;
import com.uade.seminario.tpo.view.objectView.TareaReparacionView;

public class AdministradorTareaReparacion {
	private static AdministradorTareaReparacion instancia;
	private TareaReparacionDataService tareaReparacionDataService; 
	private AdministradorTareaReparacion(){
		tareaReparacionDataService = TareaReparacionDataService.getInstance();
	}
	protected static AdministradorTareaReparacion getInstancia(){
		if(instancia==null)
			instancia=new AdministradorTareaReparacion();
		return instancia;
	}
	
	protected TareaReparacion fromDTOtoClassTransformer(TareaReparacionView trv){		
		TareaReparacion tr = new TareaReparacion();
		tr.setDetalle(trv.getDetalle());
		tr.setEstado(trv.getEstado());
		tr.setNroItemReparacion(trv.getNroItemReparacion());
//		tr.setPiezas(AdministradorPieza.getInstancia().getListFromDTOToClass(trv.getPiezas()));
		tr.setItemsReparacion(AdministradorItemsReparacion.getInstancia().
				getListFromDTOToClass(trv.getItemReparacion()));
		return tr ;		

	}
	protected void modificarTareaReparacion(TareaReparacionView tarea ){
		tareaReparacionDataService.merge(fromDTOtoClassTransformer(tarea));
		
	}
	


	
}
