package negocio;

import java.sql.Date;
import java.util.Vector;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Remito.java
//  @ Date : 29/07/2013
//  @ Author : 
//
//




public class Remito {
	private int nroRemito;
	private Date fecha;
	private Vector<ItemRemito> itemsRemito;
	private Cliente cliente;
	private Empleado empleado;
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
	public Vector<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(Vector<ItemRemito> itemsRemito) {
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