package com.elefante.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 8492394242802556588L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "description", length = 200, nullable = false)
	private String description;

	@Column(name = "ammount")
	private Double ammount;

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

}
