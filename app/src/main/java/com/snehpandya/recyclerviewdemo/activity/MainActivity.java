package com.snehpandya.recyclerviewdemo.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import com.snehpandya.recyclerviewdemo.R;
import com.snehpandya.recyclerviewdemo.apiservice.RetrofitCall;
import com.snehpandya.recyclerviewdemo.data.MyAdapter;
import com.snehpandya.recyclerviewdemo.data.Response;
import com.snehpandya.recyclerviewdemo.databinding.MainAB;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private MainAB binding;
    private RecyclerView.LayoutManager mLayoutManager;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerview.setLayoutManager(mLayoutManager);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            fillData(page);
        } else {
            Toast.makeText(this, "Please check your connection!", Toast.LENGTH_SHORT).show();
        }

        binding.recyclerview.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private void fillData(int page) {
        RetrofitCall retrofitCall = new RetrofitCall();
        Call<Response> response = retrofitCall.mTMDBApi.popularResponse("20538a1ec60bfd1df41d9b08e00e26e8", page);
        response.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response response1 = response.body();
                    MyAdapter adapter = new MyAdapter(response1.getResults());
                    binding.recyclerview.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}