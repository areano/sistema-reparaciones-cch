package com.uade.seminario.tpo.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.*;

import net.sf.jasperreports.engine.util.Java14BigDecimalHandler;

import com.uade.seminario.tpo.view.objectView.GarantiaView;

@Entity
@Table(name="garantia")
public class Garantia {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        java.sql.Date sqlDate;
        date = new java.util.Date();
		try {
			date = sdf.parse(date.toString());
			sqlDate = new Date(date.getTime());	
			if(fechaVencimiento.compareTo(sqlDate)>=0) return true;
			else return false;
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		return false;
	}
	public GarantiaView getView(){
		return new GarantiaView(String.valueOf(nroGarantia),
								fechaVencimiento.toString(), estasEnGarantia());
	}
	
}
