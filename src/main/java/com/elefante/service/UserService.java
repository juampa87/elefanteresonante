package com.elefante.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.elefante.domain.User;
import com.elefante.exception.ValidationException;

public interface UserService {

	User getUser(Integer id);

	void add(User user, MultipartFile photo) throws ValidationException;

	void delete(Integer id);

	void edit(User user);

	List<User> getAll();

}
