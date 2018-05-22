package com.ayuhani.demo.design;

/**
 * Created by wang on 2018/5/22.
 */

public class Fruit {

    private String name;
    private String imageUrl;

    public Fruit(String name, String imageId) {
        this.name = name;
        this.imageUrl = imageId;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl == null ? "" : imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
