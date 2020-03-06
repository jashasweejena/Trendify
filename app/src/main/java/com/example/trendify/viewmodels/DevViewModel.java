package com.example.trendify.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trendify.models.Developers;
import com.example.trendify.repositories.DevRepository;

import java.util.List;

public class DevViewModel extends ViewModel {
    private MutableLiveData<List<Developers>> mDevelopers;
    private DevRepository devRepo;

    //Initialize the viewmodel
    public void init() {
        if (mDevelopers != null) {
            return;
        }

        devRepo = new DevRepository();
        mDevelopers = devRepo.getDevelopers();
    }

    //Returns LiveData for View to observe
    public LiveData<List<Developers>> getDevelopers() {
        return mDevelopers;
    }

}
