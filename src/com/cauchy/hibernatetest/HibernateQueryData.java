package com.cauchy.hibernatetest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class HibernateQueryData {
	@Test
	public void testQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for (User user:list) {
				System.out.println(user);
			}
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
