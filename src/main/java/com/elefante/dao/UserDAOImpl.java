package com.elefante.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import com.elefante.domain.User;

public class UserDAOImpl extends AbstractDAO implements UserDAO {
	protected static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public List<User> findAll() throws Exception {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(User.class);
		return criteria.list();
	}

}
