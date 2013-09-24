package com.uade.seminario.tpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

import com.uade.seminario.tpo.view.objectView.ItemReparacionView;
@Entity
@Table(name="itemReparacion")
public class ItemReparacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="nro_pieza", nullable=false)
	private Pieza pieza;
	int cantidad;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int iD;
	@Column(name="nro_item_tarea_reparacion",nullable=false)
	private int nroItemReparacion;
	public ItemReparacion() {

	}
	public ItemReparacion(Pieza pieza, int cantidad) {
		this.pieza = pieza;
		this.cantidad = cantidad;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public ItemReparacionView getView(){
		ItemReparacionView view = new ItemReparacionView(pieza.getView(), cantidad);
		return view;
	}
	
}
