package com.example.trendify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.trendify.adapters.RecyclerviewAdapter;
import com.example.trendify.models.Repositories;
import com.example.trendify.viewmodels.RepositoriesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private RecyclerviewAdapter mAdapter;
    private RepositoriesViewModel mRepositoriesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recyclerview);
        mProgressBar = findViewById(R.id.progress_bar);
        mRepositoriesViewModel = ViewModelProviders.of(this).get(RepositoriesViewModel.class);

        mRepositoriesViewModel.init();

        mRepositoriesViewModel.getRepositories().observe(this, new Observer<List<Repositories>>() {
            @Override
            public void onChanged(List<Repositories> repositoriesModels) {
                mAdapter = new RecyclerviewAdapter(repositoriesModels, MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

        initRecyclerViewState();
    }

    private void initRecyclerViewState() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}