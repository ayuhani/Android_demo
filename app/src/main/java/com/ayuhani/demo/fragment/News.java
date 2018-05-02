package com.ayuhani.demo.fragment;

/**
 * Created by wang on 2018/5/2.
 */

public class News {

    private String title;
    private String content;

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
