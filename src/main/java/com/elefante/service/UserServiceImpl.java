package com.elefante.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.elefante.dao.UserDAOImpl;
import com.elefante.domain.User;

@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	protected static Logger logger = Logger.getLogger("service");

	private UserDAOImpl userDao;
	private FilesService filesService;

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public User getUser(Integer id) {
		logger.debug("Finding user by id " + id);
		return (User) this.userDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	public void add(User user, MultipartFile photo) {
		logger.debug("Adding new user");

		try {
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
		logger.debug("Deleting existing person");

	}

	public void edit(User user) {
		logger.debug("Editing existing person");

	}

	@Required
	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}

	@Required
	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}

}
