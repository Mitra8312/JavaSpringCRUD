package com.example.daosism.Models;

public class Location implements BasedModel {
    private int id;
    private String name;
    private String description;
    private String address;
    private int CountCell;
    private String MainPerson;

    public Location(String name, String description, String address, int countCell, String mainPerson, int num) {
        id = num;
        this.name = name;
        this.description = description;
        this.address = address;
        CountCell = countCell;
        MainPerson = mainPerson;
    }

    public int getCountCell() {
        return CountCell;
    }

    public void setCountCell(int countCell) {
        CountCell = countCell;
    }

    public String getMainPerson() {
        return MainPerson;
    }

    public void setMainPerson(String mainPerson) {
        MainPerson = mainPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
