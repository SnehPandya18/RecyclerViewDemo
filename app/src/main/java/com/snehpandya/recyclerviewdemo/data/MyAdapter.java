package com.snehpandya.recyclerviewdemo.data;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.databinding.ItemAB;

import java.util.List;

/**
 * Created by Sneh on 10-09-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Movies> movies;

    public MyAdapter(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAB binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.bindMovies(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemAB binding;

        MyViewHolder(ItemAB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindMovies(Movies movies) {
            binding.setMovies(movies);
            binding.executePendingBindings();
        }
    }
}