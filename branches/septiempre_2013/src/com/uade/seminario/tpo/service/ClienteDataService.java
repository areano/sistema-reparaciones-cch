package com.uade.seminario.tpo.service;

import java.util.List;
import com.uade.seminario.tpo.model.Cliente;
import com.uade.seminario.tpo.persistence.dao.generic.impl.ClienteDAOImpl;

public class ClienteDataService {
	private static ClienteDAOImpl dao;
	private static ClienteDataService cs=null;
	static {
		dao = ClienteDAOImpl.getInstancia();
	}

	private ClienteDataService(){
		
	}
	public static ClienteDataService getInstance(){
		if (cs==null){
			cs =  new ClienteDataService();
		}
		return cs;
	}
	public Cliente findByDNI(String nroDoc,String tipoDoc){
		return dao.findByDNI(nroDoc, tipoDoc);
	}
	public void save(Cliente cliente){
		dao.save(cliente);
	}
	public List<Cliente> todosLosClientes(){
		return dao.findAll();
	}
}
