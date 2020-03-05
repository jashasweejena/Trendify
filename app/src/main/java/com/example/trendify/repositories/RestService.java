package com.example.trendify.repositories;

import com.example.trendify.models.Developers;
import com.example.trendify.models.Repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RestService {
    @GET("/repositories")
    Call<List<Repositories>> getProjectList();

    @GET("/developers")
    Call<List<Developers>> getDeveloperList();

}