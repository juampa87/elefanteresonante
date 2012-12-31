package com.elefante.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elefante.domain.Client;
import com.elefante.domain.Item;
import com.elefante.domain.Project;
import com.elefante.domain.User;
import com.elefante.editors.ClientCustomEditor;
import com.elefante.editors.ItemCustomEditor;
import com.elefante.editors.UserCustomEditor;
import com.elefante.enums.Order;
import com.elefante.enums.OrderFields;
import com.elefante.enums.ServiceType;
import com.elefante.enums.StateType;
import com.elefante.exception.ValidationException;
import com.elefante.search.SearchParams;
import com.elefante.service.ClientService;
import com.elefante.service.ProjectService;
import com.elefante.service.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	protected static Logger logger = Logger.getLogger(ProjectController.class);
	private static final String REDIRECT_TO_PROJECT_LIST_AFTER_POST = "redirect:/app/project/projects";

	private ProjectService projectService;
	private UserService userService;
	private ClientService clientService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
		binder.registerCustomEditor(Client.class, new ClientCustomEditor(
				this.clientService));
		binder.registerCustomEditor(User.class, new UserCustomEditor(
				this.userService));
		binder.registerCustomEditor(Item.class, new ItemCustomEditor());
	}

	// @RequestMapping(value = "/projects", method = RequestMethod.GET)
	// public ModelAndView getProjects() {
	//
	// ModelAndView mav = new ModelAndView("projectspage");
	// logger.debug("Received request to show all projects");
	//
	// List<Project> projects = projectService.getAll();
	//
	// mav.addObject("projects", projects);
	//
	// return mav;
	// }

	@RequestMapping(value = "/project/{oid}", method = RequestMethod.GET)
	public ModelAndView getProject(@PathVariable Integer oid) {
		ModelAndView mav = new ModelAndView("project");
		logger.debug("Received request to show project with id " + oid);

		Project project = projectService.getProject(oid);
		mav.addObject("project", project);
		return mav;

	}

	@RequestMapping(value = "/addproject", method = RequestMethod.GET)
	public ModelAndView addProject() {
		ModelAndView mav = new ModelAndView("addproject");
		mav.addObject("users", this.userService.getAll());
		mav.addObject("clients", this.clientService.getAll());
		mav.addObject("services", ServiceType.values());
		mav.addObject("states", StateType.values());
		return mav;

	}

	@RequestMapping(value = "/addproject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute("project") Project project) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_PROJECT_LIST_AFTER_POST);
		logger.debug("Received request to add project");
		try {
			projectService.add(project);
		} catch (ValidationException e) {
			logger.debug("Cannot add project. Validation failed!");
			mav = new ModelAndView("addproject");
			mav.addObject("errors", e.getErrors());
			mav.addObject("users", this.userService.getAll());
			mav.addObject("clients", this.clientService.getAll());
			mav.addObject("services", ServiceType.values());
			mav.addObject("states", StateType.values());
			mav.addObject("project", project);
		}
		return mav;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteProject(
			@RequestParam(value = "oid", required = true) Integer oid) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_PROJECT_LIST_AFTER_POST);
		logger.debug("Received request to delete project with id " + oid);
		projectService.delete(oid);
		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editProject(
			@RequestParam(value = "oid", required = true) Integer oid) {
		ModelAndView mav = new ModelAndView("addproject");
		Project project = this.projectService.getProject(oid);
		mav.addObject("users", this.userService.getAll());
		mav.addObject("clients", this.clientService.getAll());
		mav.addObject("services", ServiceType.values());
		mav.addObject("states", StateType.values());
		mav.addObject("project", project);
		mav.addObject("edit", "edit");
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editProject(@ModelAttribute("project") Project project) {
		logger.debug("Received request to edit project with id "
				+ project.getId());
		ModelAndView mav = new ModelAndView(REDIRECT_TO_PROJECT_LIST_AFTER_POST);
		try {
			this.projectService.edit(project);
		} catch (ValidationException e) {
			logger.debug("Cannot edit project. Validation failed!");
			mav = new ModelAndView("addproject");
			mav.addObject("errors", e.getErrors());
			mav.addObject("users", this.userService.getAll());
			mav.addObject("clients", this.clientService.getAll());
			mav.addObject("services", ServiceType.values());
			mav.addObject("states", StateType.values());
			mav.addObject("project", project);
			mav.addObject("edit", "edit");
		}
		return mav;
	}

	@RequestMapping(value = "/projects")
	public ModelAndView search(
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "responsable", required = false) String responsable,
			@RequestParam(value = "client", required = false) String client,
			@RequestParam(value = "service", required = false) String service,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "orderField", required = false) String orderField) {
		ModelAndView mav = new ModelAndView("projectspage");
		logger.debug("Searching projects");
		SearchParams searchParams = new SearchParams();
		searchParams.setState(StringUtils.isNotEmpty(state) ? StateType
				.valueOf(state) : null);
		searchParams.setClient(client);
		searchParams.setResponsable(responsable);
		searchParams.setService(service);
		searchParams.setOrder(StringUtils.isNotEmpty(order) ? Order
				.valueOf(order) : null);
		searchParams
				.setOrderField(StringUtils.isNotEmpty(orderField) ? OrderFields
						.valueOf(orderField) : null);

		List<Project> projects = projectService.search(searchParams);
		mav.addObject("projects", projects);
		mav.addObject("users", this.userService.getAll());
		mav.addObject("clients", this.clientService.getAll());
		mav.addObject("services", ServiceType.values());
		mav.addObject("states", StateType.values());
		return mav;

	}

	@Required
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Required
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
