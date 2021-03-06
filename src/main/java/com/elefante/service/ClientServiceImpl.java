package com.elefante.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.elefante.dao.GenericDao;
import com.elefante.domain.Client;
import com.elefante.exception.BeingUsedException;
import com.elefante.exception.ValidationException;
import com.elefante.validator.ClientValidator;

@Transactional(rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

	protected static Logger logger = Logger.getLogger("service");

	private GenericDao<Client, Integer> clientDao;
	private ClientValidator clientValidator;

	public List<Client> getAll() {
		logger.debug("Retrieving all clients");
		List<Client> clients = null;
		try {
			clients = this.clientDao.findAll();
		} catch (Exception e) {
			logger.error("Error retrieving clients", e);
		}
		return clients;
	}

	public Client getClient(Integer id) {
		logger.debug("Finding client by id " + id);
		return (Client) this.clientDao.findById(id);
	}

	public void add(Client client) throws ValidationException {
		logger.debug("Adding new client");
		this.clientValidator.validate(client);
		this.clientDao.save(client);
	}

	public void delete(Integer id) throws BeingUsedException {
		logger.debug("Deleting existing client");
		Client client = this.getClient(id);
		if (this.clientDao.canBeDeleted(id)) {
			this.clientDao.delete(client);
		} else {
			logger.debug("cannot delete client because it is being used");
			throw new BeingUsedException();
		}
	}

	public void edit(Client client) throws ValidationException {
		logger.debug("Editing client: " + client.getId());
		this.clientValidator.validate(client);
		this.clientDao.update(client);
	}

	@Required
	public void setClientDao(GenericDao<Client, Integer> clientDao) {
		this.clientDao = clientDao;
	}

	@Required
	public void setClientValidator(ClientValidator clientValidator) {
		this.clientValidator = clientValidator;
	}

}
