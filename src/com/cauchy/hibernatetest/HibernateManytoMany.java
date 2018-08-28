package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.manytomanyentity.Role;
import com.cauchy.manytomanyentity.User;
import com.cauchy.utils.HibernateUtils;

public class HibernateManytoMany {
	@Test
	public void testSave() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User user1 = new User();
			user1.setUser_name("Cauchy");
			user1.setUser_password("password");
			User user2 = new User();
			user2.setUser_name("Lucy");
			user2.setUser_password("123456");
			
			Role role1 = new Role();
			role1.setRole_name("manager");
			role1.setRole_memo("总经理");
			Role role2 = new Role();
			role2.setRole_name("cooker");
			role2.setRole_memo("厨师");
			Role role3 = new Role();
			role3.setRole_name("driver");
			role3.setRole_memo("司机");
			
			// 建立联系
			// user1 -- role1 and role2
			// user2 -- role2 and role3
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			
			session.save(user1);
			session.save(user2);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
