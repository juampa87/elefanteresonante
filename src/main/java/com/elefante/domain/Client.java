package com.elefante.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 8492394242802556588L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "address", length = 200)
	private String address;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "tel", length = 50)
	private String tel;

	@Column(name = "tel2", length = 50)
	private String tel2;

	@Column(name = "description", length = 1000)
	private String description;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public String getTel2() {
		return tel2;
	}

	public String getDescription() {
		return description;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
