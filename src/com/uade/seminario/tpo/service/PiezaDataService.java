package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.PiezaDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.Pieza;
import java.util.List;
public class PiezaDataService {
	private static PiezaDAOImpl dao;
	private static PiezaDataService cs=null;
	static {
		dao = PiezaDAOImpl.getInstancia();
	}
	private PiezaDataService(){
		
	}
	public static PiezaDataService getInstance(){
		if (cs==null){
			cs =  new PiezaDataService();
		}
		return cs;
	}
	public Pieza findByNroSerie(int nroSerie){
		return dao.findByNroSerie(nroSerie);
	}
	public List<Pieza> todosLasPiezas(){
		return dao.findAll();
	}
	public void save(Pieza entidad){
		dao.save(entidad);
	}
	public void update(Pieza entidad){
		dao.update(entidad);
	}
	public void merge(Pieza pieza) {
		dao.merge(pieza);
		
	}
}
