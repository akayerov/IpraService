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
}
