package com.uade.seminario.tpo.model;

import java.sql.Date;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
	private String nombre;
	private String apellido;
	private String tipo;
	private String nroDoc;
	private String tipoDoc;
	private Date fechaNac;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String legajo;
	private String idSector;
	private Vector<OrdenReparacion> aReparar;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNroDoc() {
		return this.nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc=nroDoc;
	}
	public String getTipoDoc() {
		return this.tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getIdSector() {
		return idSector;
	}
	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}
	public Vector<OrdenReparacion> getaReparar() {
		return aReparar;
	}
	public void setaReparar(Vector<OrdenReparacion> aReparar) {
		this.aReparar = aReparar;
	}
	public boolean hayOrdenReparacion() {
		
		return !this.aReparar.isEmpty();
	}
	public void addAReparar(OrdenReparacion orden) {
		this.aReparar.add(orden);
		
	}
}
