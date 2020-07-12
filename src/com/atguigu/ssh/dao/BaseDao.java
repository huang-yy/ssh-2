package com.atguigu.ssh.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

//	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sf) {
		super.setSessionFactory(sf);
//		this.sessionFactory = sf;
	}

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//	public Session getSession1() {
//		return this.sessionFactory.getCurrentSession();
//	}

}
