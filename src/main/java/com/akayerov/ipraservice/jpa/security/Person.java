package com.akayerov.ipraservice.jpa.security;

import javax.persistence.*;

@Entity
//@Data
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
