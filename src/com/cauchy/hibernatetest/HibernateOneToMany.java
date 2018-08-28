package com.cauchy.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cauchy.entity.Customer;
import com.cauchy.entity.LinkMan;
import com.cauchy.utils.HibernateUtils;

public class HibernateOneToMany {
	@Test
	public void testAddDemo1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 1、创建客户
			Customer customer = new Customer();
			customer.setCustName("Cauchy");
			customer.setCustLevel("vip");
			customer.setCustMobile("123456");
			customer.setCustPhone("54321");
			customer.setCustSource("NetWork");
			LinkMan lkm = new LinkMan();
			lkm.setLkm_name("Lucy");
			lkm.setLkm_phone("134567");
			lkm.setLkm_gender("Man");
			// 在客户中表示联系人，在联系人中表示客户
			// 并建立联系人和客户的关系
			// 2.1 把联系人放到实体类对象的set集合中去
			customer.getSetLinkMan().add(lkm);
			// 2.2把客户对象放到联系人中
			lkm.setCustomer(customer);
			session.save(customer);
			session.save(lkm);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	@Test
	public void testDel() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, 1);
			session.delete(customer);
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
