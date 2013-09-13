package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.EquipoDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import java.util.List;
public class EquipoService {
	private static EquipoDAOImpl dao;
	private static EquipoService cs=null;
	static {
		dao = EquipoDAOImpl.getInstancia();
	}
	private EquipoService(){
		
	}
	public static EquipoService getInstance(){
		if (cs==null){
			cs =  new EquipoService();
		}
		return cs;
	}
	public Equipo findByNroSerie(int nroSerie){
		return dao.findByNroSerie(nroSerie);
	}
	public List<Equipo> todosLosEquipos(){
		return dao.findAll();
	}
}
