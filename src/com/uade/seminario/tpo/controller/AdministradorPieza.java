package com.uade.seminario.tpo.controller;

import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.service.PiezaDataService;
import com.uade.seminario.tpo.view.objectView.PiezaView;



class AdministradorPieza {
	private static AdministradorPieza instancia;
	private PiezaDataService piezaDataService; 
	private AdministradorPieza(){
		piezaDataService = PiezaDataService.getInstance();
	}
	
	protected static AdministradorPieza getInstancia(){
		if(instancia==null)
			instancia=new AdministradorPieza();
		return instancia;
	}
	private Pieza fromDTOtoClassTransformer(PiezaView piezaView){
		Pieza pieza = new Pieza();
		pieza.setDescripcion(piezaView.getDescripcion() );
		pieza.setNombrePieza(piezaView.getNombrePieza() );
		pieza.setNroPieza(piezaView.getNroPieza());
		return pieza ;
	}

	protected void altaPieza(PiezaView piezaView) {
			piezaDataService.save(fromDTOtoClassTransformer(piezaView));
	}
	protected PiezaView buscarPiezaView(int codigoPieza) {
		Pieza pieza=buscarPieza(codigoPieza);
		if(pieza!=null)
			return pieza.getView();
		else
			return null;
	}
	protected Pieza buscarPieza(int codPieza) {
		return piezaDataService.findByNroSerie(codPieza);
	}
	protected void bajaPieza(int codigoPieza) {
		Pieza pieza=buscarPieza(codigoPieza);
		if(pieza!=null && pieza.estaActiva()){
			pieza.darBajaPieza();
			piezaDataService.merge(pieza);
		}		
		
	}
	protected void modificarPieza(PiezaView piezaView) {
		Pieza pieza = fromDTOtoClassTransformer(piezaView);
		piezaDataService.merge(pieza);
	
	}
	protected List<Pieza> getListFromDTOToClass(List<PiezaView> pList){
		List<Pieza> piezas = new ArrayList<Pieza>();
		for (PiezaView pieza : pList) {
			piezas.add(fromDTOtoClassTransformer(pieza));
		}
		return piezas;
		
	}

}
