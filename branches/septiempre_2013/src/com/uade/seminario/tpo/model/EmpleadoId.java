package com.uade.seminario.tpo.model;

import javax.persistence.*;

@Embeddable
public class EmpleadoId {

	@Column(name="id_sector")
	private int nroSector;
	@Column(name="legajo")
	private int nroLegajo;

	public int getNroSector() {
		return nroSector;
	}
	public void setNroSector(int nroSector) {
		this.nroSector = nroSector;
	}
	public int getNroLegajo() {
		return nroLegajo;
	}
	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}
	
}
