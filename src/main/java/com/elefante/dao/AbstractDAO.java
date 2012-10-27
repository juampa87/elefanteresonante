package com.elefante.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;

public abstract class AbstractDAO {

	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
