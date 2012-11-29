package com.elefante.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.elefante.domain.Project;
import com.elefante.search.SearchParams;

public class ProjectDAOImpl extends GenericDaoImpl<Project, Integer> {
	protected static Logger logger = Logger.getLogger(ProjectDAOImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return Project.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findWithParams(SearchParams searchParams) {
		Criteria criteria = this.getSession(false)
				.createCriteria(Project.class);
		if (searchParams.getState() != null) {
			criteria.add(Restrictions.eq("state", searchParams.getState()));
		}

		if (!StringUtils.isEmpty(searchParams.getResponsable())) {
			criteria.createAlias("responsable", "responsable");
			criteria.add(Restrictions.eq("responsable.username",
					searchParams.getResponsable()));
		}

		if (!StringUtils.isEmpty(searchParams.getClient())) {
			criteria.createAlias("client", "client");
			criteria.add(Restrictions.eq("client.name",
					searchParams.getClient()));
		}

		if (!StringUtils.isEmpty(searchParams.getService())) {
			criteria.add(Restrictions.eq("service", searchParams.getService()));
		}

		if (searchParams.getOrderField() != null) {
			if (searchParams.getOrder() != null
					&& "DESC".equals(searchParams.getOrder().toString())) {
				criteria.addOrder(Order.desc(searchParams.getOrderField()
						.field()));
			} else {
				criteria.addOrder(Order.asc(searchParams.getOrderField()
						.field()));
			}
		}

		return criteria.list();
	}

}
