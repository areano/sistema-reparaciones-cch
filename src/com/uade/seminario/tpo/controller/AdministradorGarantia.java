package com.uade.seminario.tpo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date date;
        java.sql.Date sqlDate;
		try {
			date = sdf.parse(gv.getFechaVencimiento());
			sqlDate = new Date(date.getTime());	
			g.setFechaVencimiento(sqlDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		g.setNroGarantia(Integer.parseInt(gv.getNroGarantia()));
		return g;
	}
	
}
