package com.uade.seminario.tpo.controller;

import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.model.ItemReparacion;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.service.ItemReparacionDataService;
import com.uade.seminario.tpo.view.objectView.ItemReparacionView;
import com.uade.seminario.tpo.view.objectView.PiezaView;

public class AdministradorItemsReparacion {
	private static AdministradorItemsReparacion instancia;
	private ItemReparacionDataService itemReparacionDataService; 
	
	private AdministradorItemsReparacion(){
		itemReparacionDataService = ItemReparacionDataService.getInstance();
	}
	
	protected static AdministradorItemsReparacion getInstancia(){
		if(instancia==null)
			instancia=new AdministradorItemsReparacion();
		return instancia;
	}
	private ItemReparacion fromDTOtoClassTransformer(ItemReparacionView itemView){
		ItemReparacion item = new ItemReparacion();
		item.setCantidad(itemView.getCantidad());
		item.setPieza(AdministradorPieza.getInstancia().buscarPieza(itemView.getPieza().getNroPieza()));
		return item ;
	}

	public List<ItemReparacion> getListFromDTOToClass(
			List<ItemReparacionView> itemReparacion) {
		List<ItemReparacion> retorno = new ArrayList<ItemReparacion>();
		
		for(ItemReparacionView itemView:itemReparacion){
			retorno.add(fromDTOtoClassTransformer(itemView));
		}
		return retorno;
	}
	
}
