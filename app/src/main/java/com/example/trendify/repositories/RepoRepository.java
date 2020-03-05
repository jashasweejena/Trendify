package com.example.trendify.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.trendify.models.Repositories;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RepoRepository {
    private final static String TAG = "RepoRepository";
    private static RepoRepository instance;
    private RestService githubService;

    public RepoRepository() {
        if (githubService == null)
            githubService = RestClient.getClient().create(RestService.class);
    }

    public static RepoRepository getInstance() {
        if (instance == null) {
            instance = new RepoRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Repositories>> getRepositories() {
        MutableLiveData<List<Repositories>> data = new MutableLiveData<>();
        List<Repositories> repoList = new ArrayList<>();
        githubService.getProjectList().enqueue(new Callback<List<Repositories>>() {
            @Override
            public void onResponse(Call<List<Repositories>> call, retrofit2.Response<List<Repositories>> response) {
                data.postValue(response.body());
            }


            @Override
            public void onFailure(Call<List<Repositories>> call, Throwable t) {

            }
        });
        return data;
    }

}