package com.service;

import com.entity.Human;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by snikitin on 09.09.16.
 */
public class HumanSearchService {
    private EntityManager entityManager;

    public HumanSearchService() {
        entityManager = Persistence.createEntityManagerFactory("entityManager")
                .createEntityManager();
    }

    public List<Human> getListHuman(){
        final List<Human> result = entityManager
                .createQuery("select t from Human t")
                .getResultList();
        return result;
    }
}
