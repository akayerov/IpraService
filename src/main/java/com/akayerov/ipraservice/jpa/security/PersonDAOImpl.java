package com.akayerov.ipraservice.jpa.security;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.akayerov.ipraservice.jpa.domain.Mo;


@Repository
@Service("storagePerson")
public class PersonDAOImpl implements PersonDAO {
	@PersistenceContext
    private EntityManager em; 

	@Override
	public Person getById(int id) {
//        Person personElem = em.byId(Person.class ).load(id);
        Person p = em.find( Person.class, id );
        return p;
	}

	@Override
	public Person getByName(String username) {
		Person p = null;

		try {
			p = (Person) em.createQuery(
				    "select p " +
				    "from Person p " +
				    "where p.name = :par1")
				    .setParameter("par1",username).getSingleResult();
		} catch (Exception e) { // Не найден
		}
        return p;

	}

}