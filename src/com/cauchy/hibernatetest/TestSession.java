package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class TestSession {
	@Test
	public void testSession() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			User user1 = session.get(User.class, 1);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 此时session已经关闭
			// session.close();
		}
		
	}
}
