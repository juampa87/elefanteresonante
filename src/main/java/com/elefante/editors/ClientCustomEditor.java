package com.elefante.editors;

import java.beans.PropertyEditorSupport;

import com.elefante.domain.Client;
import com.elefante.service.ClientService;

public class ClientCustomEditor extends PropertyEditorSupport {

	ClientService clientService;

	public ClientCustomEditor(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public void setAsText(String text) {
		Client client = this.clientService.getClient(Integer.parseInt(text));
		this.setValue(client);
	}
}
