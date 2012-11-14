package com.elefante.service;

import java.util.List;

import com.elefante.domain.Client;

public interface ClientService {

	Client getClient(Integer id);

	void add(Client client);

	void delete(Integer id);

	void edit(Client client);

	List<Client> getAll();

}
