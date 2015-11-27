package com.leadingcause.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.leadingcause.entities.LeadingCause;
import com.leadingcause.util.JPAManager;



public class LeadingCauseDAO {

	private static HashSet<LeadingCause> leadingCauseSet = new HashSet<LeadingCause>();
	private EntityManager em;

	public void create(LeadingCause leadingCause) {
		em = JPAManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(leadingCause);
		em.getTransaction().commit();
		em.close();

	}
	
	public void createAll(Collection<LeadingCause> leadingCauses){
		em = JPAManager.getEntityManager();
		em.getTransaction().begin();
		for(LeadingCause leadingCause:leadingCauses){
			em.persist(leadingCause);
            em.flush();
            em.clear();
		}
		em.getTransaction().commit();
		em.close();
	}

	public List<LeadingCause> readAll() {
		em= JPAManager.getEntityManager();
		Query query = em.createNativeQuery("Select * from LeadingCause", LeadingCause.class);
		List<LeadingCause> list = (List<LeadingCause>)query.getResultList();
		em.close();
		return list;
	}
	

}
