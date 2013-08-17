package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.persistence.dao.generic.impl.EmpleadoDAOImpl;

public class EmpleadoService {
	private static EmpleadoDAOImpl dao;
	private static EmpleadoService es=null;
	static {
		dao = EmpleadoDAOImpl.getInstancia();
	}

	private EmpleadoService(){
		
	}
	public static EmpleadoService getInstance(){
		if (es==null){
			es =  new EmpleadoService();
		}
		return es;
	}
	public Empleado findByDNI(String nroDoc,String tipoDoc){
		return dao.findByDNI(nroDoc, tipoDoc);
	}
	public void save(Empleado entidad){
		dao.save(entidad);
	}
	public Empleado findByLegajo(String legajo) {
		return dao.findByLegajo(legajo);
	}
}
