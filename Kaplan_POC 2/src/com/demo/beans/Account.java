package com.demo.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.mapping.Set;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@NotBlank(message = "name is empty")
	@Length(min = 6, max=16)
	private String name;
	
	@Column(name="email")
	@NotBlank(message = "email is empty")
	@Email(message = "not an email")
	private String email;
	
	@Column(name="password")
	@NotBlank(message = "password is empty")
	@Length(min =6, max=16)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
