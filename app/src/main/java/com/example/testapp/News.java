package com.example.testapp;

public class News {
    String title;
    String description;
    String date_pub;
    boolean expanded;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }

    public News() {
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public News(String title, String description, String date_pub) {
        this.title = title;
        this.description = description;
        this.date_pub = date_pub;
        this.expanded=false;

    }
}
