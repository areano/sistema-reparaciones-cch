package com.uade.seminario.tpo.view.objectView;

public class PiezaView {
	private int nroPieza;
	private String nombrePieza;
	private String descripcion;
	private String estado;
	private int stock;
	
	public PiezaView(int nroPieza, String nombrePieza, String descripcion,
			String estado) {
		super();
		this.nroPieza = nroPieza;
		this.nombrePieza = nombrePieza;
		this.descripcion = descripcion;
		this.estado = estado;
		
	}
	public PiezaView(int codPieza, String nombre, String descripcion2) {
		this.nroPieza=codPieza;
		this.nombrePieza=nombre;
		this.descripcion=descripcion2;
		this.estado="activo";
	}
	public int getNroPieza() {
		return nroPieza;
	}
	public void setNroPieza(int nroPieza) {
		this.nroPieza = nroPieza;
	}
	public String getNombrePieza() {
		return nombrePieza;
	}
	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
