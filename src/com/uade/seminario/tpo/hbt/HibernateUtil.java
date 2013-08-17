package com.uade.seminario.tpo.hbt;

import com.uade.seminario.tpo.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	 static
	    {
	        try
	        {
	        	 AnnotationConfiguration cfg = new AnnotationConfiguration();
	        	 
	        	 cfg.addAnnotatedClass(Cliente.class);
	        	 cfg.addAnnotatedClass(Empleado.class);
	        	 cfg.addAnnotatedClass(Equipo.class);
	        	 cfg.addAnnotatedClass(Garantia.class);
	        	 cfg.addAnnotatedClass(ItemRemito.class);
	        	 cfg.addAnnotatedClass(itemReporte.class);
	        	 cfg.addAnnotatedClass(Modelo.class);
	        	 cfg.addAnnotatedClass(OrdenReparacion.class);
	        	 cfg.addAnnotatedClass(Pieza.class);
	        	 cfg.addAnnotatedClass(Remito.class);
	        	 cfg.addAnnotatedClass(Reporte.class);
	        	 cfg.addAnnotatedClass(TareaReparacion.class);

	             sessionFactory = cfg.buildSessionFactory();
	        }
	        catch (Throwable ex)
	        {
	            System.err.println("Error en la creación de la session factory." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
}
