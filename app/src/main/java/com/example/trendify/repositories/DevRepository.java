package com.example.trendify.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.trendify.models.Developers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DevRepository {
    public static final String TAG = "DevRepository";
    private static DevRepository instance;

    //Retrofit api service
    private RestService githubService;

    public DevRepository() {
        //initialize retrofit
        if (githubService == null)
            githubService = RestClient.getClient().create(RestService.class);
    }

    public static DevRepository getInstance() {
        if (instance == null) {
            instance = new DevRepository();
        }
        return instance;
    }

    //Fetch data from API and return MutableLiveData
    public MutableLiveData<List<Developers>> getDevelopers() {
        MutableLiveData<List<Developers>> data = new MutableLiveData<>();

        githubService.getDeveloperList().enqueue(new Callback<List<Developers>>() {
            @Override
            public void onResponse(Call<List<Developers>> call, retrofit2.Response<List<Developers>> response) {
                //Set API response to MutableLiveData
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Developers>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return data;
    }

}
