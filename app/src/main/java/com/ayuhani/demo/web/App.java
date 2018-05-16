package com.ayuhani.demo.web;

/**
 * Created by wang on 2018/5/16.
 */

public class App {

    private String id;
    private String name;
    private String version;

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version == null ? "" : version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
