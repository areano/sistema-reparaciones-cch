package com.uade.seminario.tpo.controller;

import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.service.ClienteDataService;
import com.uade.seminario.tpo.view.objectView.ClienteView;

class AdministradorCliente {

	private static AdministradorCliente instancia;
	private ClienteDataService clienteDataService; 
	private AdministradorCliente(){
		clienteDataService = ClienteDataService.getInstance();
	}
	protected static AdministradorCliente getInstancia(){
		if(instancia==null)
			instancia=new AdministradorCliente();
		return instancia;
	}
	protected void AltaCliente(ClienteView clienteView){
		Cliente cliente = fromDTOtoClassTransformer(clienteView);
		clienteDataService.save(cliente);
	}
	protected Cliente buscarCliente(String nroDoc, String tipoDoc) {
		ClienteDataService clienteDataService = ClienteDataService.getInstance();
		return clienteDataService.findByDNI(nroDoc, tipoDoc);
	}
	protected ClienteView obtenerClienteView(String nroDoc,String tipoDoc) {
		Cliente cliente=buscarCliente(nroDoc,tipoDoc);
		if(cliente!=null)
			return cliente.getView();
		else
			return null;
	}
	protected void modificarCliente(ClienteView clienteView) {
		
		Cliente cliente = fromDTOtoClassTransformer(clienteView);
		clienteDataService.merge(cliente);
	}
	private Cliente fromDTOtoClassTransformer(ClienteView clienteView){
		
		Cliente cliente = new Cliente();
		cliente.setApellido(clienteView.getApellido());
		cliente.setDireccion(clienteView.getDireccion());
		cliente.setEmail(clienteView.getEmail());
		cliente.setFechaNac(clienteView.getFechaNac());
		cliente.setNombre(clienteView.getNombre());
		cliente.setNroDoc(clienteView.getNroDoc());
		cliente.setTelefono(clienteView.getTelefono());
		cliente.setTipoDoc(clienteView.getTipoDoc());
		return cliente ;
		
	}

}
