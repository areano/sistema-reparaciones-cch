package com.uade.seminario.tpo.controller;

import java.util.List;

import com.uade.seminario.tpo.exceptions.ClienteNoExisteException;
import com.uade.seminario.tpo.exceptions.EquipoExisteException;
import com.uade.seminario.tpo.exceptions.EquipoNoExisteException;
import com.uade.seminario.tpo.exceptions.ExceptionNoExisteModelo;
import com.uade.seminario.tpo.exceptions.GarantiaExisteException;
import com.uade.seminario.tpo.exceptions.GarantiaNoExisteException;
import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;
import com.uade.seminario.tpo.model.Pieza;
import com.uade.seminario.tpo.service.EquipoService;
import com.uade.seminario.tpo.view.objectView.EquipoView;

public class AdministradorEquipo {
	private static AdministradorEquipo instancia;
	private EquipoService equipoDataService; 
	private AdministradorEquipo(){
		equipoDataService = EquipoService.getInstance();
	}
	
	protected static AdministradorEquipo getInstancia(){
		if(instancia==null)
			instancia=new AdministradorEquipo();
		return instancia;
	}
	protected Equipo fromDTOtoClassTransformer(EquipoView equipoView){

		Equipo equipo = new Equipo();
		equipo.setCliente(AdministradorCliente.getInstancia().fromDTOtoClassTransformer(equipoView.getCliente()));
		equipo.setEstado(equipoView.getEstado());
		equipo.setGarantia(AdministradorGarantia.getInstancia().fromDTOtoClassTransformer(equipoView.getGarantia()));
		equipo.setModelo(AdministradorModelo.getInstancia().fromDTOtoClassTransformer(equipoView.getModelo()));
		equipo.setNroSerie(equipoView.getNroSerie());
		return equipo ;
	}

	protected void altaEquipo(EquipoView equipoView)
		throws ExceptionNoExisteModelo,  ClienteNoExisteException,
		GarantiaExisteException{
			Equipo equipo;
			Garantia garantia;
			equipo = new Equipo();
			Modelo modelo=SistemadeReparaciones.getInstancia().
					buscarModelo(equipoView.getModelo().getNroModelo());
			Cliente cliente=SistemadeReparaciones.getInstancia().
					buscarCliente(equipoView.getCliente().getNroDoc(),equipoView.getCliente().getTipoDoc());
			if (equipoView.getGarantia()!=null){				
				try{
				garantia =SistemadeReparaciones.getInstancia().
						buscarGarantia(Integer.parseInt(equipoView.getGarantia().getNroGarantia()));
				throw new GarantiaExisteException("La Garantia ["+equipoView.getGarantia().getNroGarantia()
						+"] ya existe en el sistema");
				}catch(GarantiaNoExisteException e){
						garantia = AdministradorGarantia.getInstancia().
								fromDTOtoClassTransformer(equipoView.getGarantia());
						equipo.setGarantia(garantia);
				}
			}else {
				equipo.setGarantia(null);
			}				
			equipo.setCliente(cliente);				
			equipo.setModelo(modelo);
			equipo.setNroSerie(equipoView.getNroSerie());
			equipo.setEstado(equipoView.getEstado());
			equipoDataService.save(equipo);
		
	}
	protected EquipoView buscarEquipoView(int codigoEquipo) {
		Equipo equipo=buscarEquipo(codigoEquipo);
		if(equipo!=null)
			return equipo.getView();
		else
			return null;
	}
	protected Equipo buscarEquipo(int codEquipo) {
		return equipoDataService.findByNroSerie(codEquipo);
	}

	protected boolean existeElModeloEnUnEquipo(Modelo modelo) {
		if (equipoDataService.existeElModeloEnUnEquipo(modelo).size()>0)
			return true;
		return false;
	}

	protected void modificarEquipo(EquipoView equipo) {
		equipoDataService.merge( fromDTOtoClassTransformer(equipo));
		
	}
}
