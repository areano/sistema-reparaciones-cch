package negocio;

import java.sql.Date;

import vista.ClienteView;


//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Cliente.java
//  @ Date : 29/07/2013
//  @ Author : 
//
//




public class Cliente {
	private String nombre;
	private String apellido;
	private int nroDoc;
	private String tipoDoc;
	private Date fechaNac;
	private String direccion;
	private String email;
	private String telefono;
	
	public Cliente(int nroDoc, String tipoDoc, String nombre2, String apellido2,
			String direccion, String mail, String fechaNac2, String tel) {
		this.nombre=nombre2;
		this.apellido=apellido2;
		this.direccion=direccion;
		this.nroDoc=nroDoc;
		this.tipoDoc=tipoDoc;
		this.fechaNac=new Date(Date.parse(fechaNac2));
		this.email=mail;
		this.telefono=tel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public void persistite() {
		// TODO Auto-generated method stub
		
	}
	public ClienteView getView() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}