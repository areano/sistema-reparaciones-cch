package negocio;

import java.sql.Date;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Garantia.java
//  @ Date : 29/07/2013
//  @ Author : 
//
//




public class Garantia {
	private int nroGarantia;
	private Date fechaVencimiento;
	public int getNroGarantia() {
		return nroGarantia;
	}
	public void setNroGarantia(int nroGarantia) {
		this.nroGarantia = nroGarantia;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}
