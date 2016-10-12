package com.akayerov.ipraservice.jpa.security;


public interface PersonDAO {
    public Person getById(int i);
	public Person getByName(String username);
}