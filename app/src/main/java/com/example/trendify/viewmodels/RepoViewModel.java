package com.example.trendify.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trendify.models.Repositories;
import com.example.trendify.repositories.RepoRepository;

import java.util.List;

public class RepoViewModel extends ViewModel {
    private MutableLiveData<List<Repositories>> mRespositories;
    private RepoRepository repoRepo;

    public void init() {
        if (mRespositories != null) {
            return;
        }

        repoRepo = new RepoRepository();
        mRespositories = repoRepo.getRepositories();

    }

    public LiveData<List<Repositories>> getRepositories() {
        return mRespositories;
    }
}
