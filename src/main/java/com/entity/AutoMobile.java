package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by snikitin on 08.09.16.
 */
@Entity
@Table
public class AutoMobile implements Serializable {

    private static final long serialVersionUID = -5170875020617735653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private Long auto_id;

    private String Brand;

    private String Model;

    public AutoMobile() {
    }

    public AutoMobile(String brand, String model) {
        Brand = brand;
        Model = model;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id", nullable = false)
    @JsonBackReference
    private Human human;

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public Long getAuto_id() {
        return auto_id;
    }

}
