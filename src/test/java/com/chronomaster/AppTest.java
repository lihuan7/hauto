package com.chronomaster;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.testng.Assert.*;

/**
 * Created by snikitin on 07.09.16.
 */
public class AppTest extends TestCase {

    public void testApp() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AppUser user = new AppUser("firstuser");
        session.save(user);

        Human human = new Human("Иванов","Иван","Иваныч");
        session.save(human);

        session.getTransaction().commit();
        session.close();
    }
}