package com.uade.seminario.tpo.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class EmpleadoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nro_doc", columnDefinition = "varchar(12)", nullable = false)
	private String nroDoc;

	@Column(name = "tipo_doc", columnDefinition = "varchar(5)", nullable = false)
	private String tipoDoc;

	public EmpleadoId() {
	}

	public EmpleadoId(String nroDoc, String tipoDoc) {
		super();
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof EmpleadoId))
			return false;
		EmpleadoId otherClienteID = (EmpleadoId) other;
		if ((otherClienteID.getNroDoc() == this.nroDoc)
				&& (this.tipoDoc.equals(otherClienteID.getTipoDoc()))) {
			return true;
		}
		return false;
	}
}
