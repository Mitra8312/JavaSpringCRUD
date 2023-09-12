package com.example.daosism.Models;

public class Product implements BasedModel {
    private int id;
    private String name;
    private String article;
    private String Owner;
    private String Quantity;
    private String Price;

    public Product(String name, String article, String owner, String quantity, String price, Integer num) {
        id = num;
        this.name = name;
        this.article = article;
        this.Owner = owner;
        this.Quantity = quantity;
        this.Price = price;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
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
