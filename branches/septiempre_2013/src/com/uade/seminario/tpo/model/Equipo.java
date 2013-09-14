package com.uade.seminario.tpo.model;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.EquipoView;

@Entity
@Table(name="equipo")
public class Equipo {
	
	@Id
	@Column(name="nro_serie")
	private int nroSerie;
	@ManyToOne
	@JoinColumn(name="nro_modelo", nullable=false)
	private Modelo modelo;
	@ManyToOne
	@JoinColumns({@JoinColumn(name="nro_doc", nullable=false), @JoinColumn(name="tipo_doc", nullable=false)})
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="nro_garantia", nullable=false)
	private Garantia garantia;
	@Column(name="e_estado", columnDefinition="varchar(20)", nullable=false)
	private String estado;
	
	public Equipo(int nroEquipo, Modelo modelo2, Cliente cliente2,
			Garantia garantia2) {
		this.nroSerie=nroEquipo;
		this.modelo=modelo2;
		this.cliente=cliente2;
		this.garantia=garantia2;
		this.estado="inactivo";
	}
	
	public Equipo(){ //NO Tiene vectores a inicializar
		
	}
	
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Garantia getGarantia() {
		return garantia;
	}
	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public EquipoView getView() {
		EquipoView equipoV= new EquipoView(getNroSerie(), getModelo(), getCliente(), getGarantia(), getEstado());
		return equipoV;
	}
	public boolean estaActivo() {
		return getEstado().equals("activo");
	}
}
