package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by snikitin on 07.09.16.
 */
@Entity
@Table
public class Human implements Serializable {
    private static final long serialVersionUID = -3171875020617735653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "human_id")
    private Long human_id;

    String firstName;
    String middleName;
    String lastName;


    String city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "human", orphanRemoval = true)
    private List<AutoMobile> autoMobiles;

    public Human() {

    }

    public Human(final String firstName, final String middleName, final String lastName, final String city) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.city = city;
    }



    public List<AutoMobile> getAutoMobiles() {
        return this.autoMobiles;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getHuman_id() {
        return human_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
