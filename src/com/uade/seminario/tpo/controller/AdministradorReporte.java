package com.uade.seminario.tpo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.model.ItemReporte;
import com.uade.seminario.tpo.model.Reporte;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;

class AdministradorReporte {
	private static AdministradorReporte instancia;

	private AdministradorReporte(){

	}
	protected static AdministradorReporte getInstancia(){
		if(instancia==null)
			instancia=new AdministradorReporte();
		return instancia;
	}
	protected List<ItemReporte> generarListaPiezas(List<OrdenReparacionView> ordenes) {
		List<String> piezas=new ArrayList<String>();
		List<String> nombrePiezas=new ArrayList<String>();
		List<Integer> cantidad=new ArrayList<Integer>();
		List<ItemReporte> itemsReporte=new ArrayList<ItemReporte>();
		for (OrdenReparacionView ordenReparacion : ordenes) {
			nombrePiezas=ordenReparacion.listaPiezas();			
			for (String nombre : nombrePiezas) {
				if(piezas.contains(nombre)){
					int posicion=piezas.indexOf(nombre);
					cantidad.set(posicion, cantidad.get(posicion).intValue()+1);
				}
				else{
					piezas.add(nombre);
					cantidad.add(1);
				}
			}
		}
		int i=0;
		while(cantidad.size()>i){
			ItemReporte item= new ItemReporte(piezas.get(i),cantidad.get(i));
			itemsReporte.add(item);
			i++;
		}
		return itemsReporte;
	}
	protected Reporte generarReportePiezas(Date desde, Date hasta,
			List<OrdenReparacionView> ordenes) {
		Reporte reporte=new Reporte(desde,hasta);
		List<ItemReporte> itemsReporte=new ArrayList<ItemReporte>();
		itemsReporte=AdministradorReporte.getInstancia().generarListaPiezas(ordenes);		
		reporte.setItemsReporte(itemsReporte);
		return reporte;
		
	}
	
}
