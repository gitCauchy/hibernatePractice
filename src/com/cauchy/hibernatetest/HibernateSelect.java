package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class HibernateSelect {
	@Test
	public void testCash() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//根据id查询
		User user1 = session.get(User.class, 1);
		System.out.println(user1);
		// 不再需要到数据库中查询
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		session.close();
		sessionFactory.close();
	}
}
