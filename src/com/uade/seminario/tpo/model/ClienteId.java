package com.uade.seminario.tpo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClienteId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015828852452785490L;
	private String nroDoc;
	private String tipoDoc;
	public ClienteId(){
		
	}
	public ClienteId(String nroDoc, String tipoDoc) {
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
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof ClienteId))return false;
	    ClienteId otherClienteID = (ClienteId)other;
	    if ( (otherClienteID.getNroDoc()==this.nroDoc) 
	    		&&( this.tipoDoc.equals(otherClienteID.getTipoDoc()) ) )
	    {
	    	return true;
	    }
	    return false;
	}
	
}
