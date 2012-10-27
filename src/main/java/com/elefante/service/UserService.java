package com.elefante.service;

import java.util.List;

import com.elefante.domain.Person;
import com.elefante.domain.User;

public interface UserService {

	List<User> getAll();

	User getUser(Integer id);

	void add(Person person);

	void delete(Integer id);

	void edit(Person person);

}
