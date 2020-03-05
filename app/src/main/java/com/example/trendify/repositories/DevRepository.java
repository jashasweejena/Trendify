package com.example.trendify.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.trendify.models.Developers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DevRepository {
    public static final String TAG = "DevRepository";
    private static DevRepository instance;


    private RestService githubService;

    public DevRepository() {
        if (githubService == null)
            githubService = RestClient.getClient().create(RestService.class);
    }

    public static DevRepository getInstance() {
        if (instance == null) {
            instance = new DevRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Developers>> getDevelopers() {
        MutableLiveData<List<Developers>> data = new MutableLiveData<>();
        List<Developers> repoList = new ArrayList<>();
        githubService.getDeveloperList().enqueue(new Callback<List<Developers>>() {
            @Override
            public void onResponse(Call<List<Developers>> call, retrofit2.Response<List<Developers>> response) {
                data.postValue(response.body());
                Log.d(TAG, "onResponse: " + response.body().get(0).getName());
            }


            @Override
            public void onFailure(Call<List<Developers>> call, Throwable t) {

            }
        });
        return data;
    }

}
