package com.elefante.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elefante.domain.Client;
import com.elefante.exception.BeingUsedException;
import com.elefante.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	protected static Logger logger = Logger.getLogger(ClientController.class);
	private static final String REDIRECT_TO_CLIENT_LIST_AFTER_POST = "redirect:/app/client/clients";

	private ClientService clientService;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ModelAndView getClients(
			@RequestParam(value = "error", required = false) String error) {

		ModelAndView mav = new ModelAndView("clientspage");
		logger.debug("Received request to show all clients");

		List<Client> clients = clientService.getAll();

		mav.addObject("error", error);
		mav.addObject("clients", clients);

		return mav;
	}

	@RequestMapping(value = "/client/{oid}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable Integer oid) {
		ModelAndView mav = new ModelAndView("client");
		logger.debug("Received request to show client with id " + oid);

		Client client = clientService.getClient(oid);
		mav.addObject("client", client);
		return mav;

	}

	@RequestMapping(value = "/addclient", method = RequestMethod.GET)
	public ModelAndView addClient() {
		ModelAndView mav = new ModelAndView("addclient");
		return mav;

	}

	@RequestMapping(value = "/addclient", method = RequestMethod.POST)
	public ModelAndView saveClient(@ModelAttribute("client") Client client) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_CLIENT_LIST_AFTER_POST);
		logger.debug("Received request to add client");
		clientService.add(client);
		return mav;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteClient(
			@RequestParam(value = "oid", required = true) Integer oid) {
		ModelAndView mav = new ModelAndView(REDIRECT_TO_CLIENT_LIST_AFTER_POST);
		logger.debug("Received request to delete client with id " + oid);
		try {
			clientService.delete(oid);
		} catch (BeingUsedException e) {
			logger.debug("Exception thrown, maybe it's because client is being used");
			mav.addObject("error", "beingUsed");
		}
		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editClient(
			@RequestParam(value = "oid", required = true) Integer oid) {
		ModelAndView mav = new ModelAndView("addclient");
		Client client = this.clientService.getClient(oid);
		mav.addObject("client", client);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editClient(@ModelAttribute("client") Client client) {
		logger.debug("Received request to edit client with id "
				+ client.getId());
		ModelAndView mav = new ModelAndView(REDIRECT_TO_CLIENT_LIST_AFTER_POST);
		clientService.edit(client);
		return mav;
	}

	@Required
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
