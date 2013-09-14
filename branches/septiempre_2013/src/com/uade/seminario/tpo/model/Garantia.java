package com.uade.seminario.tpo.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="garantia")
public class Garantia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nro_garantia")
	private int nroGarantia;
	@Column(name="fecha_venc")
	private Date fechaVencimiento;
	
	public Garantia(int nroGarantia2, Date fecha1) {
		this.nroGarantia=nroGarantia2;
		this.fechaVencimiento=fecha1;
	}
	
	public Garantia(){ //NO tiene vectores a inicializar
		
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
	public boolean estasEnGarantia() {
		return false;
		// TODO Auto-generated method stub
		
	}
}
