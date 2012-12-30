package com.elefante.service;

import java.util.List;

import com.elefante.domain.Client;
import com.elefante.exception.BeingUsedException;

public interface ClientService {

	Client getClient(Integer id);

	void add(Client client);

	void delete(Integer id) throws BeingUsedException;

	void edit(Client client);

	List<Client> getAll();

}
