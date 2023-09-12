package com.example.daosism.Models;

public class Cell implements BasedModel{
    private int id;
    private String name;
    private int level;
    private String hash;
    private String loc;
    private String product;

    public Cell(String name, int level, String hash, String loc, String product, int num) {
        id = num;
        this.name = name;
        this.level = level;
        this.hash = hash;
        this.loc = loc;
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
