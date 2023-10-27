package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	private static SessionFactory sessionfactory;

	public static SessionFactory getSessionFactory() {
		if (sessionfactory == null) {
			sessionfactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionfactory;
	}

	public static void closeSessionFactory() {
		if (sessionfactory.isOpen()) {
			sessionfactory.close();
		}
	}
}
