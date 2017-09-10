package com.snehpandya.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.data.Movies;
import com.snehpandya.recyclerviewdemo.data.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Movies> movies;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        fillData();

        mAdapter = new MyAdapter(movies);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void fillData() {
        movies = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            movies.add(new Movies("Movie " + i));
        }
    }
}