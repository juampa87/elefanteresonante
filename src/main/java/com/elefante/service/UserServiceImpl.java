package com.elefante.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.elefante.dao.GenericDao;
import com.elefante.domain.User;
import com.elefante.exception.ValidationException;
import com.elefante.validator.UserValidator;

@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	protected static Logger logger = Logger.getLogger("service");

	private GenericDao<User, Integer> userDao;
	private FilesService filesService;
	private UserValidator userValidator;

	public List<User> getAll() {
		logger.debug("Retrieving all users");
		List<User> users = null;
		try {
			users = this.userDao.findAll();
		} catch (Exception e) {
			logger.error("Error retrieving users", e);
		}
		return users;
	}

	public User getUser(Integer id) {
		logger.debug("Finding user by id " + id);
		return (User) this.userDao.findById(id);
	}

	public void add(User user, MultipartFile photo) throws ValidationException {
		logger.debug("Adding new user");

		try {
			this.userValidator.validate(user);
			String originalName = photo.getOriginalFilename();
			String fileExtension = originalName.substring(
					originalName.length() - 4, originalName.length());
			String fileName = user.getUsername() + fileExtension;
			user.setPhoto(fileName);
			this.userDao.save(user);
			this.filesService.savePhoto(photo, fileName);
		} catch (IOException e) {
			logger.error("Error saving logo ", e);
		}
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing User");
		User user = this.getUser(id);
		try {
			this.userDao.delete(user);
			this.filesService.deletePhoto(user.getPhoto());
		} catch (IOException e) {
			logger.error("Error deleting logo ", e);
		}
	}

	public void edit(User user) {
		logger.debug("Editing existing person");

	}

	@Required
	public void setUserDao(GenericDao<User, Integer> userDao) {
		this.userDao = userDao;
	}

	@Required
	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}

	@Required
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

}
