package com.example.retrofittraining.service;

import com.example.retrofittraining.model.Countries;

import retrofit2.Call;

import retrofit2.http.GET;

public interface HttpService {
    @GET("countries")
    Call<Countries> getAll();
}
