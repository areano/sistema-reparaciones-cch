package com.uade.seminario.tpo.view.objectView;

import java.util.Vector;

import com.uade.seminario.tpo.model.Pieza;

public class ModeloView {
	private int nroModelo;
	private String nombre;
	private Vector<Pieza> piezas;
	private String estado;
	private String descripcion;
	
	
	public ModeloView(String nombre2, String descripcion, int codigo) {
		this.nombre=nombre2;
		this.descripcion=descripcion;
		this.nroModelo=codigo;
		this.piezas=new Vector<Pieza>();
		this.estado="activo";
	}


	public int getNroModelo() {
		return nroModelo;
	}


	public void setNroModelo(int nroModelo) {
		this.nroModelo = nroModelo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Vector<Pieza> getPiezas() {
		return piezas;
	}


	public void setPiezas(Vector<Pieza> piezas) {
		this.piezas = piezas;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
