package com.elefante.service;

import java.util.List;

import com.elefante.domain.Client;
import com.elefante.exception.BeingUsedException;
import com.elefante.exception.ValidationException;

public interface ClientService {

	Client getClient(Integer id);

	void add(Client client) throws ValidationException;

	void delete(Integer id) throws BeingUsedException;

	void edit(Client client) throws ValidationException;

	List<Client> getAll();

}
