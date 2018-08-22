package com.cauchy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	static {
		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	// 提供方法来调用sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	// 提供一个与本地线程绑定的session 的方法
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
}
