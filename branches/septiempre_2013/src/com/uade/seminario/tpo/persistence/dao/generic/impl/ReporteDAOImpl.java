package com.uade.seminario.tpo.persistence.dao.generic.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.seminario.tpo.controller.SistemadeReparaciones;
import com.uade.seminario.tpo.model.OrdenReparacion;
import com.uade.seminario.tpo.model.Remito;
import com.uade.seminario.tpo.persistence.dao.generic.GenericDAO;
import com.uade.seminario.tpo.persistence.hbt.HibernateUtil;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.ReporteView;

public class ReporteDAOImpl implements GenericDAO<ReporteView> {
	private static ReporteDAOImpl instancia = null;
	private static SessionFactory sf = null;
	private ReporteDAOImpl() {}
	
	public static ReporteDAOImpl getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ReporteDAOImpl();
		} 
		return instancia;
	}
	
	public ReporteView findByDate(Date FechaDesde, Date FechaHasta) {
		ReporteView reporte=new ReporteView(FechaDesde,FechaHasta);
//		List<ItemReporte> itemsReporte=new ArrayList<ItemReporte>();
		/* List<OrdenReparacion> ordenes=buscarOrdenesReporte(FechaDesde,FechaHasta);
		 * itemsReporte=generarListaPiezas(ordenes);		
		*
		*Reemplazar por reporte 
		*/
		List<ItemReporteView> itemsReporte=generarListaPiezas(FechaDesde,FechaHasta);
		reporte.setItemsReporte(itemsReporte);
		return reporte;	
	}

	private List<ItemReporteView> generarListaPiezas (Date desde, Date hasta) {
		List<ItemReporteView> itemsReporte=new ArrayList<ItemReporteView>();
		Session session =sf.openSession();
		//String hql = "select Pie.nroPieza, Pie.descripcion, count(*) from OrdenReparacion as OrRep inner join OrRep.itemsReparacion as itRep inner join itRep.piezas as Pie where OrRep.fecha between :desde and :hasta group by Pie.nroPieza, Pie.descripcion order by 1 ";
		String hql ="select IT.pieza.nroPieza, IT.pieza.descripcion, sum(IT.cantidad)  from OrdenReparacion as OrRep inner join OrRep.itemsReparacion as itRep inner join itRep.itemsReparacion as IT  between :desde and :hastagroup by IT.pieza.nroPieza,IT.pieza.descripcion order by 1" ;
		Query query = session.createQuery(hql);
		query.setParameter("desde", desde);
		query.setParameter("hasta", hasta);
		@SuppressWarnings("unchecked")
		List<Object[]> resultados= query.list();
		for (Object[] o : resultados){
			itemsReporte.add(new ItemReporteView((int)o[0], (String)o[1], (int)(long)o[2]));
		}
		session.close();
		return itemsReporte;
	}
	
//	private List<OrdenReparacion> buscarOrdenesReporte(Date desde, Date hasta) {
//		List<OrdenReparacion> ordenes=new ArrayList<OrdenReparacion>();
//
//		for (OrdenReparacion orden : ordenes) {
//			if(orden.getFecha().after(desde)&&orden.getFecha().before(hasta) && (orden.getEstado().equals("Reparado")||orden.getEstado().equals("Entregado"))){
//				ordenes.add(orden);
//			}
//		}
//		  
//		return ordenes;
//	}

//	private List<ItemReporte> generarListaPiezas(List<OrdenReparacion> ordenes) {
//		List<String> piezas=new ArrayList<String>();
//		List<String> nombrePiezas=new ArrayList<String>();
//		List<Integer> cantidad=new ArrayList<Integer>();
//		List<ItemReporte> itemsReporte=new ArrayList<ItemReporte>();
//		for (OrdenReparacion ordenReparacion : ordenes) {
//			nombrePiezas=ordenReparacion.listaPiezas();
//			
//			for (String nombre : nombrePiezas) {
//				if(piezas.contains(nombre)){
//					int posicion=piezas.indexOf(nombre);
//					cantidad.set(posicion, cantidad.get(posicion).intValue()+1);
//				}
//				else{
//					piezas.add(nombre);
//					cantidad.add(1);
//				}
//			}
//		}
//		int i=0;
//		while(cantidad.size()>i){
//			ItemReporte item= new ItemReporte(piezas.get(i),cantidad.get(i));
//			itemsReporte.add(item);
//			i++;
//		}
//		return itemsReporte;
//	}

	@Override
	public void save(ReporteView entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReporteView entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ReporteView entidad) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void merge(ReporteView entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReporteView> findAll(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}


}
