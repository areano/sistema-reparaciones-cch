package com.uade.seminario.tpo.view.objectView;

import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.model.Garantia;
import com.uade.seminario.tpo.model.Modelo;

public class EquipoView {
	private int nroSerie;
	private Modelo modelo;
	private Cliente cliente;
	private Garantia garantia;
	private String estado;
	
	
	
	public EquipoView(int nroSerie, Modelo modelo, Cliente cliente,
			Garantia garantia, String estado) {
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
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Garantia getGarantia() {
		return garantia;
	}
	public void setGarantia(Garantia garantia) {
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
