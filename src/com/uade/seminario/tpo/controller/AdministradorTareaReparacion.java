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
import com.uade.seminario.tpo.service.TareaReparacionDataService;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;
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
		tr.setPiezas(AdministradorPieza.getInstancia().getListFromDTOToClass(trv.getPiezas()));
		return tr ;		

	}
	protected void modificarTareaReparacion(TareaReparacionView tarea ){
		tareaReparacionDataService.merge(fromDTOtoClassTransformer(tarea));
		
	}
	


	
}
