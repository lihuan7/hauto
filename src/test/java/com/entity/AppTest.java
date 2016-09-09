package com.entity;

import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private EntityManager entityManager;

	public void testApp() {

		entityManager = Persistence.createEntityManagerFactory("entityManager")
				.createEntityManager();

		entityManager.getTransaction().begin();

		AppUser user = new AppUser("seconduser");
		entityManager.persist(user);

		System.out.println("add second user");


		AutoMobile autoMobile = new AutoMobile("Volkswagen","golf-6");

		List<AutoMobile> autoMobiles = new ArrayList<AutoMobile>();

		autoMobiles.add(autoMobile);

		Human human = new Human("Сидоров","Иван","Петрович",autoMobiles);

		entityManager.persist(human);

		entityManager.flush();

		autoMobile.setHuman(human);

		entityManager.persist(autoMobile);

		entityManager.flush();

		System.out.println("add autoMobile");



		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
