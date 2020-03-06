package com.example.trendify.repositories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit wrapper class
public class RestClient {
    public static final String HTTPS_API_GITHUB_URL = "https://github-trending-api.now.sh";
    private static Retrofit retrofit = null;

    //Returns a retrofit instance
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(HTTPS_API_GITHUB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
