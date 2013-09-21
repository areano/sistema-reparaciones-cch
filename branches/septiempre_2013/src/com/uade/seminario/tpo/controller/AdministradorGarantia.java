package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.service.GarantiaDataService;
import com.uade.seminario.tpo.view.objectView.GarantiaView;

public class AdministradorGarantia {
	private static AdministradorGarantia instancia;
	private GarantiaDataService garantiaDataService; 
	private AdministradorGarantia(){
		garantiaDataService = GarantiaDataService.getInstance();
	}
	protected static AdministradorGarantia getInstancia(){
		if(instancia==null)
			instancia=new AdministradorGarantia();
		return instancia;
	}
	public Garantia buscarGarantia(int nroGarantia) {
		return garantiaDataService.findByNroGarantia(nroGarantia);
	}
	public Garantia fromDTOtoClassTransformer(GarantiaView gv) { // DIFIEREN EN TODO LA GARANTIA VIEW Y LA MODEL
		Garantia g= new Garantia();
		g.setFechaVencimiento(gv.getFechaVencimiento()); 
		g.setNroGarantia(gv.getNroGarantia());
		return g;
	}
	
}
