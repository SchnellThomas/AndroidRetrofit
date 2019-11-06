package com.example.androidretrofit;

import com.example.androidretrofit.Model.Ip;
import com.example.androidretrofit.Remote.IpService;
import com.example.androidretrofit.Remote.RetrofitClient;

public class Common {

    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService()
    {
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
