package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by snikitin on 11.09.16.
 */
@Entity
@Table
public class City implements Serializable {
    private static final long serialVersionUID = -3170875020615735653L;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;


    @OneToOne(mappedBy="city")
    private Human human;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

}
