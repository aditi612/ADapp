package com.example.adapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("v3/7e79f3ab-d6ce-443a-987a-433da7b57cf4")
    Call<List<Posts>> getPosts();
}

