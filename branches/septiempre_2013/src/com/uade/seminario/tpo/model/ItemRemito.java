package com.uade.seminario.tpo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="item_remito")
public class ItemRemito implements Serializable{
	
	@Column(name="ir_detalle_falla", columnDefinition="varchar(200)")
	private String detalleReparacion;
	@Column(name="ir_detalle_equipo", columnDefinition="varchar(200)")
	private String detalleEquipo;
	@ManyToOne
	@JoinColumn(name="nro_serie", nullable=false)
	private Equipo equipo;
	@Id
	@Column(name="nro_item_remito")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int NroItemRemito;
	public String getDetalleReparacion() {
		return detalleReparacion;
	}
	public ItemRemito(){ //No tiene vectores a inicializar
		
	}
	public void setDetalleReparacion(String detalleReparacion) {
		this.detalleReparacion = detalleReparacion;
	}
	public String getDetalleEquipo() {
		return detalleEquipo;
	}
	public void setDetalleEquipo(String detalleEquipo) {
		this.detalleEquipo = detalleEquipo;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public int getNroItemRemito() {
		return NroItemRemito;
	}
	public void setNroItemRemito(int nroItemRemito) {
		NroItemRemito = nroItemRemito;
	}
}
