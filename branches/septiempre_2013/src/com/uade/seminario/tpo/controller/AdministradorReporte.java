package com.uade.seminario.tpo.controller;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.seminario.tpo.service.ReporteDataService;
import com.uade.seminario.tpo.view.objectView.ItemReporteView;
import com.uade.seminario.tpo.view.objectView.OrdenReparacionView;
import com.uade.seminario.tpo.view.objectView.ReporteView;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
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

	protected ReporteView generarReportePiezas(Date desde, Date hasta){
		return  reporteDataService.findByDate(desde, hasta);
	}
	


	protected void GenerarDynamicReporte(ReporteView rv, Date desde, Date hasta){
		FontBuilder  boldFont = stl.fontArialBold().setFontSize(12);
		
		TextColumnBuilder<Integer>     modelColumn = col.column("N° de Serie",       "nroSerie",      type.integerType());
		TextColumnBuilder<String>    descColumn  = col.column("Descripción",   "descripcion",  type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Cantidad", "cantidad", type.integerType());
		
		modelColumn.setPattern("000");
		
		try {
			report()
			  .setTemplate(Templates.reportTemplate)
			  .columns(modelColumn, descColumn, quantityColumn)
			  .title(Templates.createTitleComponent(desde.toString() + " a " + hasta.toString(),"Reporte de Utilización de Piezas")) 
			  .summary(
			  	cht.bar3DChart()
			  	   .setTitle("Gráfico")
			  	   .setTitleFont(boldFont)
			  	   .setCategory(descColumn)
			  	   .series(
			  	  		 cht.serie(quantityColumn))
			  	   .setCategoryAxisFormat(
			  	   	cht.axisFormat()
			  	   	   .setLabel("")))
			  .pageFooter(Templates.footerComponent)
			  .setDataSource(createDataSource(rv))
			  .show(false);
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	
	private JRDataSource createDataSource(ReporteView rv) {
		DRDataSource dataSource = new DRDataSource("nroSerie", "descripcion", "cantidad");
		
		for (ItemReporteView irv: rv.getItemsReporte())
			dataSource.add(irv.getNroPieza(), irv.getDescripcionPieza(), irv.getCantidadPieza());
		return dataSource;
	}
	
	

}
