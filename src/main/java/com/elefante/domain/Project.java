package com.elefante.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.elefante.enums.ServiceType;
import com.elefante.enums.StateType;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	private static final long serialVersionUID = 4347244313025597671L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "reference_number", length = 10, nullable = false)
	private String referenceNumber;

	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "responsable_id")
	private User responsable;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "product", length = 100, nullable = false)
	private String product;

	@Column(name = "service", nullable = false)
	private ServiceType studio;

	@Column(name = "total")
	private Integer total;

	@Column(name = "state", length = 20, nullable = false)
	private StateType state;

	@Column(name = "description", length = 1000)
	private String description;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public User getResponsable() {
		return responsable;
	}

	public Client getClient() {
		return client;
	}

	public String getProduct() {
		return product;
	}

	public ServiceType getStudio() {
		return studio;
	}

	public Integer getTotal() {
		return total;
	}

	public StateType getState() {
		return state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setStudio(ServiceType studio) {
		this.studio = studio;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
