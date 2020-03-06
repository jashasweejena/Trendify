package com.example.trendify.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendify.R;
import com.example.trendify.adapters.DevRecyclerviewAdapter;
import com.example.trendify.models.Developers;
import com.example.trendify.viewmodels.DevViewModel;

import java.util.List;

//Fragment that handles showing Developers
public class DevelopersFragment extends Fragment {
    private static DevelopersFragment instance;
    private RecyclerView recyclerView;
    private DevViewModel mDevelopersViewModel;
    private DevRecyclerviewAdapter mDevAdapter;

    public static DevelopersFragment getInstance() {
        if (instance == null) {
            instance = new DevelopersFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        initDevRecyclerViewState();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Get reference to ViewModel
        mDevelopersViewModel = ViewModelProviders.of(this).get(DevViewModel.class);

        mDevelopersViewModel.init();

        //Update UI based on data from API
        mDevelopersViewModel.getDevelopers().observe(getViewLifecycleOwner(), new Observer<List<Developers>>() {
            @Override
            public void onChanged(List<Developers> developersModels) {
                mDevAdapter = new DevRecyclerviewAdapter(developersModels, getContext());
                recyclerView.setAdapter(mDevAdapter);
            }
        });
    }

    private void initDevRecyclerViewState() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(mDevAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
