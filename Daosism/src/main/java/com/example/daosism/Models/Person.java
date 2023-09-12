package com.example.daosism.Models;

public class Person implements BasedModel {
    private int id;
    private String name;
    private String secondName;
    private int age;
    private String family;

    public Person(String name, String secondName, int age, String family, Integer num) {
        id = num;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
