package com.snehpandya.recyclerviewdemo.data;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.databinding.ItemAB;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sneh on 10-09-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Result> mResults;

    public MyAdapter(List<Result> results) {
        this.mResults = results;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAB binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.bindResult(mResults.get(position));
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemAB binding;

        MyViewHolder(ItemAB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindResult(Result result) {
            binding.setResult(result);
            binding.executePendingBindings();
        }
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String url) {
        String IMAGE_URL = "http://image.tmdb.org/t/p/w342";
        Picasso.with(imageView.getContext()).load(IMAGE_URL + url).into(imageView);
        imageView.setAdjustViewBounds(true);
    }
}