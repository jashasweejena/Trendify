package com.example.trendify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendify.R;
import com.example.trendify.models.Developers;

import java.util.List;

public class DevRecyclerviewAdapter extends RecyclerView.Adapter<DevRecyclerviewAdapter.ViewHolder> {

    private List<Developers> mDevelopers;
    private Context mContext;


    public DevRecyclerviewAdapter(List<Developers> mDevelopers, Context mContext) {
        this.mDevelopers = mDevelopers;
        this.mContext = mContext;
    }

    public DevRecyclerviewAdapter() {
    }

    @NonNull
    @Override
    public DevRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dev, parent, false);
        DevRecyclerviewAdapter.ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DevRecyclerviewAdapter.ViewHolder holder, int i) {
        TextView usernameTextView = holder.getUsername();
        TextView nameTextView = holder.getName();
        TextView urlTextView = holder.getUrl();

        usernameTextView.setText(mDevelopers.get(i).getUsername());
        nameTextView.setText(mDevelopers.get(i).getName());
        urlTextView.setText(mDevelopers.get(i).getUrl());
    }

    @Override
    public int getItemCount() {
        return mDevelopers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public TextView name;
        public TextView url;

        public ViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username_dev);
            name = itemView.findViewById(R.id.name_dev);
            url = itemView.findViewById(R.id.url_dev);
        }

        public TextView getUsername() {
            return username;
        }

        public TextView getName() {
            return name;
        }

        public TextView getUrl() {
            return url;
        }
    }
}
