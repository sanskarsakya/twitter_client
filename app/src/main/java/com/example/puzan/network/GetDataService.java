package com.example.puzan.network;


import com.example.puzan.models.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("/photos?_start=0&_limit=10")
    Call<List<RetroPhoto>> getAllPhotos();
}