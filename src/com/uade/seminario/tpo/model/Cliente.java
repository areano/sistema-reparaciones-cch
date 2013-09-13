package com.uade.seminario.tpo.model;

import java.sql.Date;

import javax.persistence.*;

import com.uade.seminario.tpo.view.objectView.ClienteView;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Column(name="cli_nombre", columnDefinition="varchar(20)", nullable=false)
	private String nombre;
	@Column(name="cli_apellido", columnDefinition="varchar(20)", nullable=false)
	private String apellido;
	@EmbeddedId
	public ClienteId id;
	@Column(name="cli_fecha_nacimiento", nullable=false)
	private Date fechaNac;
	@Column(name="direccion", columnDefinition="varchar(50)")
	private String direccion;
	@Column(name="email", columnDefinition="varchar(20)")
	private String email;
	@Column(name="telefono", columnDefinition="varchar(20)")
	private String telefono;
	
	public Cliente(){
		this.id = new ClienteId();
	}
	public Cliente(String nroDoc, String tipoDoc, String nombre2, String apellido2,
			String direccion, String mail, String fechaNac2, String tel) {
		this.nombre=nombre2;
		this.apellido=apellido2;
		this.direccion=direccion;
		this.fechaNac=new Date(Date.parse(fechaNac2));
		this.email=mail;
		this.telefono=tel;
		this.id = new ClienteId(nroDoc, tipoDoc);
		
	}

	public ClienteId getId() {
		return id;
	}
	
	public void setId(ClienteId id) {
		this.id = id;
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
	public String getNroDoc() {
		return this.id.getNroDoc();
	}
	public void setNroDoc(String nroDoc) {
		this.id.setNroDoc(nroDoc);
	}
	public String getTipoDoc() {
		return this.id.getTipoDoc();
	}
	public void setTipoDoc(String tipoDoc) {
		this.id.setTipoDoc(tipoDoc);
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
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
