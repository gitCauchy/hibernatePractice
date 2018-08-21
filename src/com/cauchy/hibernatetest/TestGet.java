package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class TestGet {
	@Test
	public void testGet() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 1);
		System.out.println(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
