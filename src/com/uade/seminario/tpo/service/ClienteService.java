package com.uade.seminario.tpo.service;

import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.persistence.dao.generic.impl.ClienteDAOImpl;

public class ClienteService {
	private static ClienteDAOImpl dao;
	private static ClienteService cs=null;
	static {
		dao = ClienteDAOImpl.getInstancia();
	}

	private ClienteService(){
		
	}
	public static ClienteService getInstance(){
		if (cs==null){
			cs =  new ClienteService();
		}
		return cs;
	}
	public Cliente findByDNI(String nroDoc,String tipoDoc){
		return dao.findByDNI(nroDoc, tipoDoc);
	}
	public void save(Cliente cliente){
		dao.save(cliente);
	}
}
