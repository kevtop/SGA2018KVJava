package edu.sga.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public abstract class AbstractSession {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
}
