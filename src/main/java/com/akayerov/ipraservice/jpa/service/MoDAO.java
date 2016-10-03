package com.akayerov.ipraservice.jpa.service;

import java.util.List;

import com.akayerov.ipraservice.jpa.domain.Mo;



public interface MoDAO {
    public void save(Mo m);
    public void update(int id, Mo m);
    public List<Mo> list();
    public Mo getById(int i);
	public Mo getByOgrn(String ogrn);
    public void delete( Mo m);
}