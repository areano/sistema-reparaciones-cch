package com.uade.seminario.tpo.model;

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
	public Garantia(int nroGarantia2, Date fecha1) {
		this.nroGarantia=nroGarantia2;
		this.fechaVencimiento=fecha1;
	}
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
