package com.leadingcause.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManager {

	private static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("LeadingCauses");

		}
		return emf.createEntityManager();
	}

}
