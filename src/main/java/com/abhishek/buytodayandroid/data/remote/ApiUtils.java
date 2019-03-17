package com.abhishek.buytodayandroid.data.remote;

/**
 * Created by m63mobilebanking on 15/3/19.
 */


public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://buytoday-spontaneous-panda.cfapps.io/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}