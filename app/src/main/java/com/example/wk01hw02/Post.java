/*
Title: Post.java
Purpose: layout of our data that is returned by the API
 */
package com.example.wk01hw02;

public class Post {
    //JSON returned from request has these 4 fields
    /*NOTE: you could vary these names, but you need to use
    @SerializedName("jsonvar") to make sure it sees it correctly
    */
    private int userId; //id of the user
    private int id; //id of the post
    private String title; //title of the post
    private String body; //body of the post

    //Getters
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
