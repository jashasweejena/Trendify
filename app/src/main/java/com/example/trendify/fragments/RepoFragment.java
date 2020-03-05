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
import com.example.trendify.adapters.RepoRecyclerviewAdapter;
import com.example.trendify.models.Repositories;
import com.example.trendify.viewmodels.RepoViewModel;

import java.util.List;

public class RepoFragment extends Fragment {
    private static RepoFragment instance;
    private RecyclerView recyclerView;
    private RepoViewModel mRepositoriesViewModel;
    private RepoRecyclerviewAdapter mRepoAdapter;

    public static RepoFragment getInstance() {
        if (instance == null) {
            instance = new RepoFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        initRepoRecyclerViewState();

        mRepositoriesViewModel = ViewModelProviders.of(this).get(RepoViewModel.class);

        mRepositoriesViewModel.init();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRepositoriesViewModel.getRepositories().observe(getViewLifecycleOwner(), new Observer<List<Repositories>>() {
            @Override
            public void onChanged(List<Repositories> repositoriesModels) {
                mRepoAdapter = new RepoRecyclerviewAdapter(repositoriesModels, getContext());
                recyclerView.setAdapter(mRepoAdapter);
            }
        });

    }

    private void initRepoRecyclerViewState() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(mRepoAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
