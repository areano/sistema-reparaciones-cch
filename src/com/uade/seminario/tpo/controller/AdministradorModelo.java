package com.uade.seminario.tpo.controller;

import java.util.List;

import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.service.ModeloDataService;
import com.uade.seminario.tpo.view.objectView.ModeloView;

public class AdministradorModelo {
	private static AdministradorModelo instancia;
	private ModeloDataService modeloDataService; 
	private AdministradorModelo(){
		modeloDataService = ModeloDataService.getInstance();
	}
	
	protected static AdministradorModelo getInstancia(){
		if(instancia==null)
			instancia=new AdministradorModelo();
		return instancia;
	}
	private Modelo fromDTOtoClassTransformer(ModeloView modeloView){
		List<Pieza> piezas = AdministradorPieza.getInstancia().
				getListFromDTOToClass(modeloView.getPiezas());
		Modelo modelo = new Modelo();
		modelo.setDescripcion(modeloView.getDescripcion());
		modelo.setEstado(modeloView.getEstado());
		modelo.setNombre(modeloView.getNombre());
		modelo.setNroModelo(modeloView.getNroModelo());		
		modelo.setPiezas(piezas);
		return modelo ;
	}

	protected void altaModelo(ModeloView modeloView) {
			modeloDataService.save(fromDTOtoClassTransformer(modeloView));
	}
	protected ModeloView buscarModeloView(int codigoModelo) {
		Modelo modelo=buscarModelo(codigoModelo);
		if(modelo!=null)
			return modelo.getView();
		else
			return null;
	}
	protected Modelo buscarModelo(int codModelo) {
		return modeloDataService.findByNroSerie(codModelo);
	}

	public boolean hayModelosConPieza(Pieza pieza) {
		if (modeloDataService.hayModelosConPieza(pieza).size()>0)
			return true;
		return false;
	}

	public void modificarModelo(ModeloView modelo) {
		modeloDataService.merge( fromDTOtoClassTransformer(modelo));
		
	}
}
