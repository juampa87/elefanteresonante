package com.elefante.dao;

import org.apache.log4j.Logger;

import com.elefante.domain.User;

public class UserDAOImpl extends GenericDaoImpl implements UserDAO {
	protected static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	protected Class getEntityClass() {
		return User.class;
	}

}
