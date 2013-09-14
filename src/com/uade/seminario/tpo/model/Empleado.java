package com.uade.seminario.tpo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Column(name = "empl_nombre", columnDefinition = "varchar(20)", nullable = false)
	private String nombre;

	@Column(name = "empl_apellido", columnDefinition = "varchar(20)", nullable = false)
	private String apellido;

	@EmbeddedId
	private EmpleadoId id;

	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	@Column(name = "legajo", nullable = false)
	private int legajo;

	@Column(name = "id_sector", nullable = false)
	private String idSector;

	@OneToMany
	@JoinTable(name = "tabla_trabajos"
			, joinColumns = {@JoinColumn(name = "nro_doc"), @JoinColumn(name = "tipo_doc") }
			, inverseJoinColumns = { @JoinColumn(name = "nro_orden_reparacion") })
	private List<OrdenReparacion> aReparar;
	
	public Empleado(){
		
		this.aReparar=new Vector<OrdenReparacion>();
		
	}
	
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

	public String getNroDoc() {
		return id.getNroDoc();
	}

	public void setNroDoc(String nroDoc) {
		this.id.setNroDoc(nroDoc);
	}

	public String getTipoDoc() {
		return this.id.getTipoDoc();
	}

	public void setTipoDoc(String tipoDoc) {
		this.id.setTipoDoc(tipoDoc);
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getIdSector() {
		return idSector;
	}

	public void setIdSector(String idSector) {
		this.idSector = idSector;
	}

	public List<OrdenReparacion> getaReparar() {
		return aReparar;
	}

	public void setaReparar(ArrayList<OrdenReparacion> arrayList) {
		this.aReparar = arrayList;
	}

	public boolean hayOrdenReparacion() {

		return !this.aReparar.isEmpty();
	}

	public void addAReparar(OrdenReparacion orden) {
		this.aReparar.add(orden);

	}
}
