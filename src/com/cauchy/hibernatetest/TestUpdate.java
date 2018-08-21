package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class TestUpdate {
	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// 现将要查询的对象查询出来
		User user = session.get(User.class,1);
		// 修改
		user.setPassword("131212");
		session.update(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	
}
