package com.elefante.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.elefante.dao.GenericDao;
import com.elefante.domain.Item;
import com.elefante.domain.Project;
import com.elefante.exception.ValidationException;
import com.elefante.search.SearchParams;
import com.elefante.validator.ProjectValidator;

@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

	protected static Logger logger = Logger.getLogger("service");

	private GenericDao<Project, Integer> projectDao;
	private ProjectValidator projectValidator;

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

	public void add(Project project) throws ValidationException {
		logger.debug("Adding new project");
		project.setCreationDate(new Date());
		project.setReferenceNumber(this.projectDao.getRefNumber(new Date()));
		project.setTotal(this.calculateTotal(project));
		this.projectValidator.validate(project);
		this.projectDao.save(project);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing project");
		Project project = this.getProject(id);
		this.projectDao.delete(project);

	}

	public void edit(Project project) throws ValidationException {
		logger.debug("Editing project with oid: " + project.getId());
		Project oldProject = this.getProject(project.getId());
		oldProject.setCharges(project.getCharges());
		oldProject.setClient(project.getClient());
		oldProject.setCosts(project.getCosts());
		oldProject.setDescription(project.getDescription());
		oldProject.setProduct(project.getProduct());
		oldProject.setResponsable(project.getResponsable());
		oldProject.setBillNumber(project.getBillNumber());
		oldProject.setService(project.getService());
		oldProject.setState(project.getState());
		oldProject.setTotal(this.calculateTotal(project));
		this.projectValidator.validate(oldProject);
		this.projectDao.update(oldProject);

	}

	public List<Project> search(SearchParams searchParams) {
		logger.debug("Searching with params" + searchParams);
		return this.projectDao.findWithParams(searchParams);
	}

	private Integer calculateTotal(Project project) {
		Integer costsCounter = 0;
		if (project.getCosts() != null) {
			for (Item item : project.getCosts()) {
				costsCounter += item.getAmmount();
			}
		}
		return costsCounter;

	}

	@Required
	public void setProjectDao(GenericDao<Project, Integer> projectDao) {
		this.projectDao = projectDao;
	}

	@Required
	public void setProjectValidator(ProjectValidator projectValidator) {
		this.projectValidator = projectValidator;
	}

}
