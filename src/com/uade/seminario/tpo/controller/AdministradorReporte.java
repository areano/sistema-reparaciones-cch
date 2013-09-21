package com.uade.seminario.tpo.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.service.ReporteDataService;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.ReporteView;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

class AdministradorReporte {
	private static AdministradorReporte instancia;
	private static ReporteDataService reporteDataService;
	private AdministradorReporte(){

	}
	protected static AdministradorReporte getInstancia(){
		if(instancia==null){
			instancia=new AdministradorReporte();
			reporteDataService=ReporteDataService.getInstance();
		}
		return instancia;
	}
	protected List<ItemReporteView> generarListaPiezas(List<OrdenReparacionView> ordenes) {
		List<String> piezas=new ArrayList<String>();
		List<String> nombrePiezas=new ArrayList<String>();
		List<Integer> cantidad=new ArrayList<Integer>();
		List<ItemReporteView> itemsReporte=new ArrayList<ItemReporteView>();
		for (OrdenReparacionView ordenReparacion : ordenes) {
			nombrePiezas=ordenReparacion.listaPiezas();			
			for (String nombre : nombrePiezas) {
				if(piezas.contains(nombre)){
					int posicion=piezas.indexOf(nombre);
					cantidad.set(posicion, cantidad.get(posicion).intValue()+1);
				}
				else{
					piezas.add(nombre);
					cantidad.add(1);
				}
			}
		}
		int i=0;
		while(cantidad.size()>i){
			ItemReporteView item= new ItemReporteView(piezas.get(i),cantidad.get(i));
			itemsReporte.add(item);
			i++;
		}
		return itemsReporte;
	}
	protected ReporteView generarReportePiezas(Date desde, Date hasta,
			List<OrdenReparacionView> ordenes) {
		ReporteView reporte=new ReporteView(desde,hasta);
		List<ItemReporteView> itemsReporte=new ArrayList<ItemReporteView>();
		itemsReporte=AdministradorReporte.getInstancia().generarListaPiezas(ordenes);		
		reporte.setItemsReporte(itemsReporte);
		return reporte;
		
	}
	protected ReporteView generarReportePiezas(Date desde, Date hasta){
		return  reporteDataService.findByDate(desde, desde);
	}
	
	protected void GenerarDynamicReporte(){
		try {
			JasperReportBuilder report = DynamicReports.report();
			report.addColumn(Columns.column("Item", "item", DataTypes.stringType()));
			report.addColumn(Columns.column("Quantity", "quantity", DataTypes.integerType()));
			report.addColumn(Columns.column("Unit price", "unitprice", DataTypes.bigDecimalType()));
			report.addTitle(Components.text("Getting started"));
			report.addPageFooter(Components.pageXofY());
			report.setDataSource(createDataSource());
			report.show();
		} catch (DRException e) {
			e.printStackTrace(); 
	    }
	}
	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Notebook", 1, new BigDecimal(500));
		dataSource.add("DVD", 5, new BigDecimal(30));
		dataSource.add("DVD", 1, new BigDecimal(28));
		dataSource.add("DVD", 5, new BigDecimal(32));
		dataSource.add("Book", 3, new BigDecimal(11));
		dataSource.add("Book", 1, new BigDecimal(15));
		dataSource.add("Book", 5, new BigDecimal(10));
		dataSource.add("Book", 8, new BigDecimal(9));
		return dataSource;
	}
	
}
