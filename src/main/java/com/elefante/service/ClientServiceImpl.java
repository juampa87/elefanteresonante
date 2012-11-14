package com.elefante.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.elefante.dao.GenericDao;
import com.elefante.domain.Client;
import com.elefante.domain.User;

@Transactional(rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

	protected static Logger logger = Logger.getLogger("service");

	private GenericDao<Client, Integer> clientDao;

	public List<Client> getAll() {
		logger.debug("Retrieving all users");
		List<Client> clients = null;
		try {
			clients = this.clientDao.findAll();
		} catch (Exception e) {
			logger.error("Error retrieving clients", e);
		}
		return clients;
	}

	public Client getClient(Integer id) {
		logger.debug("Finding user by id " + id);
		return (Client) this.clientDao.findById(id);
	}

	public void add(Client client) {
		logger.debug("Adding new client");
		this.clientDao.save(client);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing client");
		Client client = this.getClient(id);
		this.clientDao.delete(client);

	}

	public void edit(User user) {
		logger.debug("Editing existing person");

	}

	public void edit(Client client) {
		// TODO Auto-generated method stub

	}

	@Required
	public void setClientDao(GenericDao<Client, Integer> clientDao) {
		this.clientDao = clientDao;
	}

}
