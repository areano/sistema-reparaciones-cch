package com.uade.seminario.tpo.view.objectView;


public class GarantiaView {

	private String nroGarantia;
	private String fechaVencimiento;
	private boolean estasEnGarantia;
	public GarantiaView(String nroGarantia, String fechaVencimiento,boolean estasEnGarantia) {
		super();
		this.nroGarantia = nroGarantia;
		this.fechaVencimiento = fechaVencimiento;
		this.estasEnGarantia = estasEnGarantia;
	}
	public String getNroGarantia() {
		return nroGarantia;
	}
	public void setNroGarantia(String nroGarantia) {
		this.nroGarantia = nroGarantia;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public boolean isEstasEnGarantia() {
		return estasEnGarantia;
	}
	public void setEstasEnGarantia(boolean estasEnGarantia) {
		this.estasEnGarantia = estasEnGarantia;
	}
	
	
}
