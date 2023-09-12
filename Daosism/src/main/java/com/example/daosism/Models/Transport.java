package com.example.daosism.Models;

public class Transport implements BasedModel {
    private int id;
    private String name;
    private String number;
    private String description;
    private String driver;
    private String location;

    public Transport(String name, String number, String description, String driver, String location, int num) {
        id = num;
        this.name = name;
        this.number = number;
        this.description = description;
        this.driver = driver;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setID(int Id) {
        id = Id;
    }
}
