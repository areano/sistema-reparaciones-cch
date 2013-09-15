package com.uade.seminario.tpo.view.objectView;

import java.util.ArrayList;
import java.util.List;

public class TareaReparacionView {
	private int nroItemReparacion;
	private String detalle;
	private List<PiezaView> piezas;
	private String estado;
	
	public TareaReparacionView(int nroItem,String descripcion, List<PiezaView> piezas2, String estado2) {
		this.nroItemReparacion=nroItem;
		this.piezas=piezas2;
		this.detalle=descripcion;
		this.estado=estado2;
		
	}
	public TareaReparacionView() {
		piezas = new ArrayList<PiezaView>();
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
	public List<PiezaView> getPiezas() {
		return piezas;
	}
	public void setPiezas(List<PiezaView> piezas) {
		this.piezas = piezas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void addPieza(PiezaView pieza){
		piezas.add(pieza);
	}
	

}
