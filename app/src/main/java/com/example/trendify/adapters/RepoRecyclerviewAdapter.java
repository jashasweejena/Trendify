package com.example.trendify.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendify.R;
import com.example.trendify.models.Repositories;

import java.util.List;

public class RepoRecyclerviewAdapter extends RecyclerView.Adapter<RepoRecyclerviewAdapter.ViewHolder> {

    private List<Repositories> mRepositories;
    private Context mContext;

    public RepoRecyclerviewAdapter(List<Repositories> mRepositories, Context mContext) {
        this.mRepositories = mRepositories;
        this.mContext = mContext;
    }

    public RepoRecyclerviewAdapter() {
    }

    @NonNull
    @Override
    public RepoRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_repositories, parent, false);
        RepoRecyclerviewAdapter.ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //Fetch the fields from ViewHolder
        TextView nameTextView = holder.getNameTextView();
        TextView descriptionTextView = holder.getDescriptionTextView();
        TextView languageTextView = holder.getLanguageTextView();
        TextView starsTextView = holder.getStarsTextView();
        TextView forksTextView = holder.getForksTextView();

        //Set values to the fields declared above
        nameTextView.setText(mRepositories.get(i).getName());
        descriptionTextView.setText(mRepositories.get(i).getDescription());
        languageTextView.setText(mRepositories.get(i).getLanguage());
        starsTextView.setText(mRepositories.get(i).getStars());
        forksTextView.setText(mRepositories.get(i).getForks());

        Log.d("", "onBindViewHolder: " + i);
    }


    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private TextView languageTextView;
        private TextView starsTextView;
        private TextView forksTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name);
            descriptionTextView = itemView.findViewById(R.id.description);
            languageTextView = itemView.findViewById(R.id.language);
            starsTextView = itemView.findViewById(R.id.stars);
            forksTextView = itemView.findViewById(R.id.forks);
        }

        public TextView getNameTextView() {
            return nameTextView;
        }

        public TextView getDescriptionTextView() {
            return descriptionTextView;
        }

        public TextView getLanguageTextView() {
            return languageTextView;
        }

        public TextView getStarsTextView() {
            return starsTextView;
        }

        public TextView getForksTextView() {
            return forksTextView;
        }
    }
}
