package com.mop.korac.mopstar.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://mentorship-api.ministryofprogramming.com/";
    public static Retrofit retrofit = null;

    public static Retrofit GetApiClient() {

        if (retrofit == null) {

            Gson gson = new GsonBuilder().create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
