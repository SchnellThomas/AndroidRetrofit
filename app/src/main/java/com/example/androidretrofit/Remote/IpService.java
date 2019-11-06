package com.example.androidretrofit.Remote;

import com.example.androidretrofit.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {
    @GET("/")
    Call<Ip> getIP();
}
