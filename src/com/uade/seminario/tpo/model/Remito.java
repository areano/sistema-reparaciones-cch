package com.uade.seminario.tpo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="remito")
public class Remito implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_remito")
	private int nroRemito;
	@Column(name="r_fecha")
	private Date fecha;
	@OneToMany()
	@JoinColumn(name="nro_remito", referencedColumnName="nro_remito")
	private List<ItemRemito> itemsRemito;
	@Transient
	private Cliente cliente;
	@Transient
	private Empleado empleado;
	
	public Remito(){
		this.itemsRemito=new ArrayList<ItemRemito>();
	}
	
	public int getNroRemito() {
		return nroRemito;
	}
	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(ArrayList<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
