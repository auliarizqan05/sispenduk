package com.sispenduk.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	
	public final static Session getSession(){
		return SessionFactoryUtils.getSession(getSessionFactory(), true);
	}
	
}
