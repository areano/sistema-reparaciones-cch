package com.uade.seminario.tpo.view.objectView;
import java.util.List;

public class EmpleadoView {


	private String nombre;
	private String apellido;
	private String nroDoc;
	private String tipoDoc;
	private String fechaNac;
	private int legajo;
	private String idSector;
	private List<OrdenReparacionView> aReparar;
	public EmpleadoView(){};
	public EmpleadoView(String nombre, String apellido, String nroDoc,
			String tipoDoc, String fechaNac, int legajo, String idSector,
			List<OrdenReparacionView> aReparar) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.fechaNac = fechaNac;
		this.legajo = legajo;
		this.idSector = idSector;
		this.aReparar = aReparar;
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
		return nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
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
	public List<OrdenReparacionView> getaReparar() {
		return aReparar;
	}
	public void setaReparar(List<OrdenReparacionView> aReparar) {
		this.aReparar = aReparar;
	}
	
	
}
