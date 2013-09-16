package com.uade.seminario.tpo.view.objectView;

public class PiezaView {
	private int nroPieza;
	private String descripcion;
	private String estado;

	
	public PiezaView(int codPieza, String descripcion2) {
		this.nroPieza=codPieza;
		this.descripcion=descripcion2;
		this.estado="activo";
	}
	public int getNroPieza() {
		return nroPieza;
	}
	public void setNroPieza(int nroPieza) {
		this.nroPieza = nroPieza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
