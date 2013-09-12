package com.uade.seminario.tpo.view.objectView;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.TareaReparacion;

public class OrdenReparacionView {
	private int nroOrden;
	private List<TareaReparacion> itemsReparacion;
	private Equipo equipo;
	private Date fecha;
	private String estado;
	private String descripcionFallas;
	private boolean estaEnGarantiaFisica;
	private boolean repararDeTodosModos;
	private int prioridad;
	

	
	public OrdenReparacionView(int nroOrden2, String descripcionFallas2,
			Equipo equipo2, String estado2, Date fecha2,
			List<TareaReparacion> itemsReparacion2, int prioridad2,boolean repararDeTodos,boolean garantiaFisica) {
		this.nroOrden=nroOrden2;
		this.descripcionFallas=descripcionFallas2;
		this.equipo=equipo2;
		this.estado=estado2;
		this.fecha=fecha2;
		this.itemsReparacion=itemsReparacion2;
		this.prioridad=prioridad2;
		this.repararDeTodosModos=repararDeTodos;
		this.estaEnGarantiaFisica=garantiaFisica;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public List<TareaReparacion> getItemsReparacion() {
		return itemsReparacion;
	}
	public void setItemsReparacion(List<TareaReparacion> itemsReparacion) {
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
