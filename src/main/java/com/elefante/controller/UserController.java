package com.elefante.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.elefante.domain.User;
import com.elefante.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	protected static Logger logger = Logger.getLogger(UserController.class);

	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsers() {

		ModelAndView mav = new ModelAndView("userspage");
		logger.debug("Received request to show all users");

		List<User> users = userService.getAll();

		mav.addObject("users", users);

		return mav;
	}

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
