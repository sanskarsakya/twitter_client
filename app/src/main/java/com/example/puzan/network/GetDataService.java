package com.example.puzan.network;


import com.example.puzan.models.RetroPhoto;
import com.example.puzan.models.Tweet;
import com.example.puzan.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("/photos?_start=0&_limit=10")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/api/users")
    Call<List<User>> getAllUsers();

    @POST("/api/users")
    Call<List<User>> createUser(@Body User user);

    @POST("/api/users/login")
    Call<Void> login(@Body User user);

    @GET("/api/tweets")
    Call<List<Tweet>> getAllTweets();

}