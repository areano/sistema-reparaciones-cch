package com.uade.seminario.tpo.view.objectView;

import java.util.Vector;

import com.uade.seminario.tpo.model.Pieza;

public class TareaReparacionView {
	private int nroItemReparacion;
	private String detalle;
	private Vector<Pieza> piezas;
	private String estado;
	
	public TareaReparacionView(int nroItem,String descripcion, Vector<Pieza> piezas2, String estado2) {
		this.nroItemReparacion=nroItem;
		this.piezas=piezas2;
		this.detalle=descripcion;
		this.estado=estado2;
		
	}
	public int getNroItemReparacion() {
		return nroItemReparacion;
	}
	public void setNroItemReparacion(int nroItemReparacion) {
		this.nroItemReparacion = nroItemReparacion;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	

}
