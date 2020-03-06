package com.example.trendify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class RepoDetails extends AppCompatActivity {

    private CircleImageView mAvatar;
    private TextView mDescriptionTextView;
    private TextView mLangDetails;
    private TextView mStarsTextView;
    private TextView mForksTextView;
    private TextView mNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);

        mAvatar = findViewById(R.id.avatar_repo_details);
        mDescriptionTextView = findViewById(R.id.description_details);
        mLangDetails = findViewById(R.id.language_details);
        mStarsTextView = findViewById(R.id.stars_details);
        mForksTextView = findViewById(R.id.forks_details);
        mNameTextView = findViewById(R.id.name_repo_details);

        Intent intent = getIntent();

        String name = intent.getStringExtra(getString(R.string.name));
        String description = intent.getStringExtra(getString(R.string.description));
        String language = intent.getStringExtra(getString(R.string.language));
        String stars = intent.getStringExtra(getString(R.string.stars));
        String forks = intent.getStringExtra(getString(R.string.forks));
        String avatar = intent.getStringExtra(getString(R.string.avatar));

        mDescriptionTextView.setText(description);
        mLangDetails.setText(language);
        mStarsTextView.setText(stars);
        mForksTextView.setText(forks);
        mNameTextView.setText(name);
        Glide.with(this).load(avatar).into(mAvatar);
    }


}
