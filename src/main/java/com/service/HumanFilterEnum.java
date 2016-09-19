package com.service;

/**
 * Перечень параметров по которым могут быть отфильтрованы люди в UI.
 *
 * @author snikitin
 */
public enum HumanFilterEnum {
    firstName("firstName"), middleName("middleName"), lastName("lastName"), cityName("cityName"), autoMark("autoMark"), autoModel("autoModel");

    private final String name;

    private HumanFilterEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}