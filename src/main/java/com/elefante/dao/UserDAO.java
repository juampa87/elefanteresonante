package com.elefante.dao;

import java.util.List;

import com.elefante.domain.User;

public interface UserDAO {

	List<User> findAll() throws Exception;

}
