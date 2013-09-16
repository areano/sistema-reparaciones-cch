package com.uade.seminario.tpo.model;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.PiezaView;

@Entity
@Table(name="pieza")
public class Pieza {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_pieza")
	private int nroPieza;

	@Column(name="p_descripcion",columnDefinition="varchar(20)")
	private String descripcion;
	@Column(name="p_estado",columnDefinition="varchar(20)")
	private String estado;

	
	public Pieza(){ 
		
	}
	
	public Pieza(int codPieza, String descripcion2) {
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
	public boolean hayStock() {

		return false;
	}
	public void darBajaPieza() {
		setEstado("inactivo");
		
	}
	public PiezaView getView() {
		PiezaView piezaview=new PiezaView(getNroPieza(), getDescripcion());
		piezaview.setEstado(estado);
		return piezaview;
		
	}
	public boolean estaActiva() {
		
		return estado.equals("activo");
	}
}
