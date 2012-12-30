package com.elefante.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.elefante.domain.Client;
import com.elefante.domain.Project;

public class ClientDAOImpl extends GenericDaoImpl<Client, Integer> {
	protected static Logger logger = Logger.getLogger(ClientDAOImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return Client.class;
	}

	@Override
	public Boolean canBeDeleted(Integer id) {
		Criteria criteria = this.getSession(false)
				.createCriteria(Project.class);
		criteria.add(Restrictions.eq("client.id", id));
		return criteria.list().isEmpty();
	}
}
