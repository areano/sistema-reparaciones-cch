package com.uade.seminario.tpo.service;

import java.util.List;

import com.uade.seminario.tpo.model.Empleado;
import com.uade.seminario.tpo.persistence.dao.generic.impl.EmpleadoDAOImpl;

public class EmpleadoDataService {
	private static EmpleadoDAOImpl dao;
	private static EmpleadoDataService es=null;
	static {
		dao = EmpleadoDAOImpl.getInstancia();
	}

	private EmpleadoDataService(){
		
	}
	public static EmpleadoDataService getInstance(){
		if (es==null){
			es =  new EmpleadoDataService();
		}
		return es;
	}
	public Empleado findByDNI(String nroDoc,String tipoDoc){
		return dao.findByDNI(nroDoc, tipoDoc);
	}
	public void save(Empleado entidad){
		dao.save(entidad);
	}
	public Empleado findByLegajo(int legajo) {
		return dao.findByLegajo(legajo);
	} 
	public List<Empleado> todosLosEmpleados(){
		return dao.findAll();
	}
}
