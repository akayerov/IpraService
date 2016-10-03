package com.akayerov.ipraservice.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akayerov.ipraservice.jpa.domain.Mo;



@Repository
@Service("storageMo")
public class MoDAOImpl implements MoDAO {
	@PersistenceContext
    private EntityManager em; 

    @Override
    @Transactional
    public void save(Mo p) {
    	 em.persist(p);    
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Mo> list() {
        return em.createQuery("from Mo", Mo.class).getResultList();
    }

	@Override
	public Mo getById(int id) {
//        Person personElem = em.byId(Person.class ).load(id);
        Mo moElem = em.find( Mo.class, id );
        return moElem;
	}

	@Override
	@Transactional
	public void update(int id, Mo moupdate) {
        Mo moElem = em.find( Mo.class, id );
        if( moupdate.getName() != null)
        	moElem.setName(moupdate.getName());
        if( moupdate.getScode() != null)
        	moElem.setScode(moupdate.getScode());
        if( moupdate.getInn() != null)
        	moElem.setInn(moupdate.getInn());
        if( moupdate.getOgrn() != null)
        	moElem.setOgrn(moupdate.getOgrn());
        em.flush();
	}

	@Override
	public Mo getByOgrn(String sogrn) {
		Mo moElem = null;

		try {
			moElem = (Mo) em.createQuery(
				    "select m " +
				    "from Mo m " +
				    "where m.ogrn = :par1")
				    .setParameter("par1",sogrn).getSingleResult();
		} catch (Exception e) { // Не найден
		}
        return moElem;
	}

	@Override
	public void delete(Mo mo) {
		Mo moElem = em.find( Mo.class, mo.getId() );
		em.remove(moElem);
		
	}
 
}