package com.service;

import com.entity.AutoMobile;
import com.entity.City;
import com.entity.Human;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by snikitin on 09.09.16.
 */
public class HumanService {
    private EntityManager entityManager;

    public HumanService() {
        entityManager = Persistence.createEntityManagerFactory("entityManager")
                .createEntityManager();
    }

    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    public void endTransaction(){
        entityManager.getTransaction().commit();
    }

    public City addCity(final String cityName){
        City city = new City(cityName);
        entityManager.persist(city);
        entityManager.flush();
        return  city;
    }

    public Human addHuman(final String firstName,final String middleName,final String lastName, final City city){
        Human human = new Human(firstName,middleName,lastName);
        human.setCity(city);
        entityManager.persist(human);
        entityManager.flush();
        return  human;
    }

    public void addAutoToHuman(final String barand,final String model,final Human human){
        final AutoMobile autoMobile = new AutoMobile(barand,model);
        autoMobile.setHuman(human);
        entityManager.persist(autoMobile);
        entityManager.flush();
    }

    public List<Human> getListHuman(){
        final List<Human> result = entityManager
                .createQuery("select t from Human t")
                .getResultList();
        return result;
    }

    public List<Human> findHumans(final Map<HumanFilterEnum, String> filterColumnList) {
        final StringBuilder strQuery = new StringBuilder(300);

        strQuery.append("SELECT DISTINCT s.* FROM human  s LEFT OUTER JOIN automobile a ON s.human_id = a.human_id  " +
                " LEFT JOIN city c ON s.city_id = c.city_id WHERE ");
        strQuery.append(getWhereClause(filterColumnList));
        Query query = entityManager.createNativeQuery(strQuery.toString(), Human.class);
        substituteParams(filterColumnList, query);
        return  (List<Human>) query.getResultList();
    }

    private String getWhereClause(final Map<HumanFilterEnum, String> filterColumnList) {
        final StringBuilder sbuf = new StringBuilder(150);
        if (filterColumnList.containsKey(HumanFilterEnum.firstName)) {
            sbuf.append("s.firstname = ?1 and ");  //Указанный статус
        }
        if (filterColumnList.containsKey(HumanFilterEnum.middleName)) {
            sbuf.append("s.middlename = ?2 and ");
        }
        if (filterColumnList.containsKey(HumanFilterEnum.lastName)) {
            sbuf.append("s.lastname = ?3 and ");
        }
        if (filterColumnList.containsKey(HumanFilterEnum.cityName)) {
            sbuf.append("c.name = ?4 and ");
        }
        if (filterColumnList.containsKey(HumanFilterEnum.autoMark)) {
            sbuf.append("a.brand = ?5 and ");
        }
        if (filterColumnList.containsKey(HumanFilterEnum.autoModel)) {
            sbuf.append("a.model = ?6 and ");
        }

        sbuf.append("1 = 1 ");
        return sbuf.toString();
    }

    private void substituteParams(final Map<HumanFilterEnum, String> filterColumnList, final Query query) {
        if (filterColumnList.containsKey(HumanFilterEnum.firstName)) {
            query.setParameter(1, filterColumnList.get(HumanFilterEnum.firstName));
        }
        if (filterColumnList.containsKey(HumanFilterEnum.middleName)) {
            query.setParameter(2, filterColumnList.get(HumanFilterEnum.middleName));
        }
        if (filterColumnList.containsKey(HumanFilterEnum.lastName)) {
            query.setParameter(3, filterColumnList.get(HumanFilterEnum.lastName));
        }
        if (filterColumnList.containsKey(HumanFilterEnum.cityName)) {
            query.setParameter(4, filterColumnList.get(HumanFilterEnum.cityName));
        }
        if (filterColumnList.containsKey(HumanFilterEnum.autoMark)) {
            query.setParameter(5, filterColumnList.get(HumanFilterEnum.autoMark));
        }
        if (filterColumnList.containsKey(HumanFilterEnum.autoModel)) {
            query.setParameter(6, filterColumnList.get(HumanFilterEnum.autoModel));
        }

    }
}
