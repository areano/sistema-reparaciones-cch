package com.uade.seminario.tpo.model;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.PiezaView;

@Entity
@Table(name="pieza")
public class Pieza {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_pieza")
	private int nroPieza;
	@Transient
	private String nombrePieza;
	@Column(name="p_descripcion",columnDefinition="varchar(20)")
	private String descripcion;
	@Column(name="p_estado",columnDefinition="varchar(20)")
	private String estado;
	@Transient
	private int stock;
	
	public Pieza(){ 
		
	}
	
	public Pieza(int codPieza, String nombre, String descripcion2) {
		this.nroPieza=codPieza;
		this.nombrePieza=nombre;
		this.descripcion=descripcion2;
		this.estado="activo";
		this.stock=0;
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
	public boolean hayStock() {

		return false;
	}
	public void darBajaPieza() {
		setEstado("inactivo");
		
	}
	public PiezaView getView() {
		PiezaView piezaview=new PiezaView(getNroPieza(), getNombrePieza(), getDescripcion());
		return piezaview;
		
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean estaActiva() {
		
		return estado.equals("activo");
	}
}
