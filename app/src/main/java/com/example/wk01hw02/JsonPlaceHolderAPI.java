/*
Title: JsonPlaceHolderAPI.java
Purpose: Used for the retrofit call to actually retrieve data from the API
 */
package com.example.wk01hw02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    //this is a retrofit call, this is essentially the endpoint we need to access to get data from the API
    //Since this will pull all posts, we need to narrow it later to just posts with our userId
    @GET("posts")
    Call<List<Post>> getPosts();
}
