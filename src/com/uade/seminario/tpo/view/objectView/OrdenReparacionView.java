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
	private String descripcionFallas;
	private boolean estaEnGarantiaFisica;
	private boolean repararDeTodosModos;
	private int prioridad;
	
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
	public String getDescripcionFallas() {
		return descripcionFallas;
	}
	public void setDescripcionFallas(String descripcionFallas) {
		this.descripcionFallas = descripcionFallas;
	}
	public boolean isEstaEnGarantiaFisica() {
		return estaEnGarantiaFisica;
	}
	public void setEstaEnGarantiaFisica(boolean estaEnGarantiaFisica) {
		this.estaEnGarantiaFisica = estaEnGarantiaFisica;
	}
	public boolean isRepararDeTodosModos() {
		return repararDeTodosModos;
	}
	public void setRepararDeTodosModos(boolean repararDeTodosModos) {
		this.repararDeTodosModos = repararDeTodosModos;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
}
