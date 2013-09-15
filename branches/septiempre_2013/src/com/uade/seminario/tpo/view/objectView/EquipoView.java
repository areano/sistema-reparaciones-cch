package com.uade.seminario.tpo.view.objectView;

import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;

public class EquipoView {
	private int nroSerie;
	private ModeloView modelo;
	private ClienteView cliente;
	private GarantiaView garantia;
	private String estado;
	
	
	public EquipoView(){
		
	}
	public EquipoView(int nroSerie, ModeloView modelo, ClienteView cliente,
			GarantiaView garantia, String estado) {
		super();
		this.nroSerie = nroSerie;
		this.modelo = modelo;
		this.cliente = cliente;
		this.garantia = garantia;
		this.estado = estado;
	}
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public ModeloView getModelo() {
		return modelo;
	}
	public void setModelo(ModeloView modelo) {
		this.modelo = modelo;
	}
	public ClienteView getCliente() {
		return cliente;
	}
	public void setCliente(ClienteView cliente) {
		this.cliente = cliente;
	}
	public GarantiaView getGarantia() {
		return garantia;
	}
	public void setGarantia(GarantiaView garantia) {
		this.garantia = garantia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean estaActivo() {
		return getEstado().equals("activo");
	}
	
}
