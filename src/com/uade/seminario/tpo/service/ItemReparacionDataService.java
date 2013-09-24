package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.persistence.dao.generic.impl.ItemReparacionDAOImpl;
import com.uade.seminario.tpo.model.Equipo;
import com.uade.seminario.tpo.model.ItemReparacion;
import com.uade.seminario.tpo.model.Pieza;
import java.util.List;
public class ItemReparacionDataService {
	private static ItemReparacionDAOImpl dao;
	private static ItemReparacionDataService cs=null;
	static {
		dao = ItemReparacionDAOImpl.getInstancia();
	}
	private ItemReparacionDataService(){
		
	}
	public static ItemReparacionDataService getInstance(){
		if (cs==null){
			cs =  new ItemReparacionDataService();
		}
		return cs;
	}
	public ItemReparacion findByNroTareaYPieza(int nroTarea, int nroPieza){
		return dao.findByNroTareaYPieza(nroTarea, nroPieza);
	}
	public List<ItemReparacion> todosLasPiezas(){
		return dao.findAll();
	}
	public void save(ItemReparacion entidad){
		dao.save(entidad);
	}
	public void update(ItemReparacion entidad){
		dao.update(entidad);
	}
	public void merge(ItemReparacion pieza) {
		dao.merge(pieza);
		
	}
}
