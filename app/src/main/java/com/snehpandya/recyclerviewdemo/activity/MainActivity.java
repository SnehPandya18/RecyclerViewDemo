package com.snehpandya.recyclerviewdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.data.Movies;
import com.snehpandya.recyclerviewdemo.data.MyAdapter;
import com.snehpandya.recyclerviewdemo.databinding.MainAB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAB binding;

    List<Movies> movies;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillData();

        mAdapter = new MyAdapter(movies);
        binding.recyclerview.setAdapter(mAdapter);
    }

    private void fillData() {
        movies = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            movies.add(new Movies("Movie " + i));
        }
    }
}