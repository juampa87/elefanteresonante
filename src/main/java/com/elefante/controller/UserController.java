package com.elefante.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elefante.domain.User;
import com.elefante.exception.BeingUsedException;
import com.elefante.exception.ValidationException;
import com.elefante.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	protected static Logger logger = Logger.getLogger(UserController.class);
	private static final String REDIRECT_TO_USER_LIST_AFTER_POST = "redirect:/user/users";

	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsers(
			@RequestParam(value = "error", required = false) String error) {

		ModelAndView mav = new ModelAndView("userspage");
		logger.debug("Received request to show all users");

		List<User> users = userService.getAll();

		mav.addObject("users", users);
		mav.addObject("error", error);
		return mav;
	}

	@RequestMapping(value = "/user/{oid}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable Integer oid) {
		ModelAndView mav = new ModelAndView("user");
		logger.debug("Received request to show user with id " + oid);

		User user = userService.getUser(oid);
		mav.addObject("user", user);
		return mav;

	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("adduser");
		return mav;

	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView saveUser(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "photo", required = false) CommonsMultipartFile photo) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_USER_LIST_AFTER_POST);
		logger.debug("Received request to add user");
		User user = new User();
		user.setUsername(username);
		try {
			userService.add(user, photo);
		} catch (ValidationException e) {
			logger.debug("Cannot add user. Validation failed!");
			mav = new ModelAndView("adduser");
			mav.addObject("errors", e.getErrors());
			mav.addObject("user", user);
		}
		return mav;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteUser(
			@RequestParam(value = "oid", required = true) Integer oid) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_USER_LIST_AFTER_POST);
		logger.debug("Received request to delete user with id " + oid);
		try {
			userService.delete(oid);
		} catch (BeingUsedException e) {
			logger.debug("Exception thrown, maybe it's because user is being used");
			mav.addObject("error", "beingUsed");
		}
		return mav;

	}

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
