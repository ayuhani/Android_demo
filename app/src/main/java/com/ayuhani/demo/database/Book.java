package com.ayuhani.demo.database;

import org.litepal.crud.DataSupport;

/**
 * Created by wang on 2018/5/4.
 */

public class Book extends DataSupport {

    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    public String getPress() {
        return press == null ? "" : press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
