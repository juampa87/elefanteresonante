package com.elefante.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.elefante.domain.Project;
import com.elefante.domain.User;

public class UserDAOImpl extends GenericDaoImpl<User, Integer> {
	protected static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return User.class;
	}

	@Override
	public Boolean canBeDeleted(Integer id) {
		Criteria criteria = this.getSession(false)
				.createCriteria(Project.class);
		criteria.add(Restrictions.eq("responsable.id", id));
		return criteria.list().isEmpty();
	}

}
