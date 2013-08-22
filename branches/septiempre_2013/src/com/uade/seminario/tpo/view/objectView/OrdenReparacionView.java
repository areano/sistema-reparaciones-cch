package com.uade.seminario.tpo.view.objectView;

import java.sql.Date;
import java.util.Vector;

import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.TareaReparacion;

public class OrdenReparacionView {
	private int nroOrden;
	private Vector<TareaReparacion> itemsReparacion;
	private Equipo equipo;
	private Date fecha;
	private String estado;
	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public Vector<TareaReparacion> getItemsReparacion() {
		return itemsReparacion;
	}
	public void setItemsReparacion(Vector<TareaReparacion> itemsReparacion) {
		this.itemsReparacion = itemsReparacion;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
