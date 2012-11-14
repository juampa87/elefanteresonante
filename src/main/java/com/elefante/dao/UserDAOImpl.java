package com.elefante.dao;

import org.apache.log4j.Logger;

import com.elefante.domain.User;

public class UserDAOImpl extends GenericDaoImpl<User, Integer> {
	protected static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return User.class;
	}

}
