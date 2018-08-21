package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.cauchy.entity.User;
import com.cauchy.utils.HibernateUtils;

public class HibernateDemo {
	@Test
	public void testAdd() {
		// 加载核心配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		// 创建SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 创建Session
		Session session = sessionFactory.openSession();
		// 开启事务操作
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername("Cauchy");
		user.setPassword("password");
		user.setAddress("Beijing");
		session.save(user);
		// 提交事务
		tx.commit();
		// 关闭 session
		session.close();
		// 关闭SessionFactory
		sessionFactory.close();
	}	
	@Test
	public void testAdd2() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername("Lucy");
		user.setPassword("123456");
		user.setAddress("Shanghai");
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
