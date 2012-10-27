package com.elefante.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.elefante.dao.UserDAOImpl;
import com.elefante.domain.Person;
import com.elefante.domain.User;

@Transactional
public class UserServiceImpl implements UserService {

	protected static Logger logger = Logger.getLogger("service");

	private UserDAOImpl userDao;

	public List<User> getAll() {
		logger.debug("Retrieving all users");
		List<User> users = null;
		try {
			users = this.userDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public User getUser(Integer id) {
		return new User();
	}

	public void add(Person person) {
		logger.debug("Adding new person");

	}

	public void delete(Integer id) {
		logger.debug("Deleting existing person");

	}

	public void edit(Person person) {
		logger.debug("Editing existing person");

	}

	@Required
	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}

}
