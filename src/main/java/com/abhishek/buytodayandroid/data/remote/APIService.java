package com.abhishek.buytodayandroid.data.remote;

/**
 * Created by m63mobilebanking on 15/3/19.
 */

import com.abhishek.buytodayandroid.model.LoginRequest;
import com.abhishek.buytodayandroid.model.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("/home/login")
    Call<List<LoginResponse>> login(@Body LoginRequest loginRequest);
}