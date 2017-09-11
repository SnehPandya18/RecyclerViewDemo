package com.snehpandya.recyclerviewdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.data.Result;
import com.snehpandya.recyclerviewdemo.databinding.DetailAB;
import com.squareup.picasso.Picasso;

/**
 * Created by sneh.pandya on 11/09/17.
 */

public class DetailActivity extends AppCompatActivity {

    private String IMAGE_URL = "http://image.tmdb.org/t/p/w342";
    Result mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetailAB binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        mResult = getIntent().getExtras().getParcelable("movie");

        binding.movieTitle.setText(mResult.getOriginalTitle());
        Picasso.with(this).load(IMAGE_URL + mResult.getPosterPath()).into(binding.movieImage);
        binding.movieDescription.setText(mResult.getOverview());
        binding.movieVote.setText(mResult.getVoteAverage());
        binding.movieDate.setText(mResult.getReleaseDate());
    }
}