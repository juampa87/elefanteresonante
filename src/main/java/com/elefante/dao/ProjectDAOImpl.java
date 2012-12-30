package com.elefante.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.elefante.domain.Project;
import com.elefante.enums.ServiceType;
import com.elefante.search.SearchParams;

public class ProjectDAOImpl extends GenericDaoImpl<Project, Integer> {
	protected static Logger logger = Logger.getLogger(ProjectDAOImpl.class);
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleDateFormat formater = new SimpleDateFormat("MM-yy");

	private static String GET_REF_NUMBER = "SELECT count FROM `elefante`.`ref_numbers` WHERE id=:id;";
	private static String NEW_REF_NUMBER = "INSERT INTO ref_numbers (id,count) VALUES (:id,1) ON DUPLICATE KEY UPDATE count=count+1;";

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
			criteria.add(Restrictions.eq("responsable.id",
					Integer.parseInt(searchParams.getResponsable())));
		}

		if (!StringUtils.isEmpty(searchParams.getClient())) {
			criteria.createAlias("client", "client");
			criteria.add(Restrictions.eq("client.id",
					Integer.parseInt(searchParams.getClient())));
		}

		if (!StringUtils.isEmpty(searchParams.getService())) {
			criteria.add(Restrictions.eq("service",
					ServiceType.valueOf(searchParams.getService())));
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

	@Override
	public String getRefNumber(Date today) {
		Map<String, Object> params = new HashMap<String, Object>();
		String formattedDate = this.formater.format(today);
		params.put("id", formattedDate);
		this.simpleJdbcTemplate.update(NEW_REF_NUMBER, params);
		return String.format("%03d/%s",
				this.simpleJdbcTemplate.queryForInt(GET_REF_NUMBER, params),
				formattedDate);
	}

	@Required
	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}

}
