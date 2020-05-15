package com.gmmustafa.rxjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("author")
    @Expose
    private String author;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}