package com.elefante.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.elefante.dao.GenericDao;
import com.elefante.domain.Item;
import com.elefante.domain.Project;
import com.elefante.search.SearchParams;
import com.google.common.collect.Lists;

@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

	protected static Logger logger = Logger.getLogger("service");

	private GenericDao<Project, Integer> projectDao;

	public List<Project> getAll() {
		logger.debug("Retrieving all projects");
		List<Project> projects = null;
		try {
			projects = this.projectDao.findAll();
		} catch (Exception e) {
			logger.error("Error retrieving projects", e);
		}
		return projects;
	}

	public Project getProject(Integer id) {
		logger.debug("Finding project by id " + id);
		return (Project) this.projectDao.findById(id);
	}

	public void add(Project project) {
		logger.debug("Adding new project");
		project.setCreationDate(new Date());
		// mockeado.. sacar
		Item item1 = new Item();
		item1.setDescription("un cargo1");
		item1.setAmmount(1);
		Item item2 = new Item();
		item2.setDescription("un cargo2");
		item2.setAmmount(2);
		Item item3 = new Item();
		item3.setDescription("un costo3");
		item3.setAmmount(3);
		List<Item> cargos = Lists.newArrayList(item1, item2);
		List<Item> costos = Lists.newArrayList(item3);
		project.setCosts(costos);
		project.setCharges(cargos);

		// hasta aca
		this.projectDao.save(project);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing project");
		Project project = this.getProject(id);
		this.projectDao.delete(project);

	}

	public void edit(Project project) {
		// TODO Auto-generated method stub

	}

	public List<Project> search(SearchParams searchParams) {
		logger.debug("Searching with params" + searchParams);
		return this.projectDao.findWithParams(searchParams);
	}

	@Required
	public void setProjectDao(GenericDao<Project, Integer> projectDao) {
		this.projectDao = projectDao;
	}

}
