package com.elefante.dao;

import org.apache.log4j.Logger;

import com.elefante.domain.Client;

public class ClientDAOImpl extends GenericDaoImpl<Client, Integer> {
	protected static Logger logger = Logger.getLogger(ClientDAOImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return Client.class;
	}

}
