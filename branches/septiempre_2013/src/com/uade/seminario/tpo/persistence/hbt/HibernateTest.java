package com.uade.seminario.tpo.persistence.hbt;


/**
 * Esta es una clase de prueba para trabajar la configuracion de las
 * entities de Hibernate.
 * Una vez que el mapeo esta listo se puede eleminar.
 */
public class HibernateTest {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory().openSession();
		HibernateUtil.getSessionFactory().close();
	}
}
