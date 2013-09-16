package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.service.GarantiaDataService;

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
	
}
