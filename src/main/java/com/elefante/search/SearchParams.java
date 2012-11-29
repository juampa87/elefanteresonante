package com.elefante.search;

import com.elefante.enums.Order;
import com.elefante.enums.OrderFields;
import com.elefante.enums.StateType;

public class SearchParams {
	private StateType state;
	private String responsable;
	private String client;
	private String service;
	private OrderFields orderField;
	private Order order;

	public StateType getState() {
		return state;
	}

	public String getResponsable() {
		return responsable;
	}

	public String getClient() {
		return client;
	}

	public String getService() {
		return service;
	}

	public OrderFields getOrderField() {
		return orderField;
	}

	public Order getOrder() {
		return order;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setOrderField(OrderFields orderField) {
		this.orderField = orderField;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "SearchParams [state=" + state + ", responsable=" + responsable
				+ ", client=" + client + ", service=" + service
				+ ", orderField=" + orderField + ", order=" + order + "]";
	}

}
