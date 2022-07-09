package com.example.retrofittraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofittraining.adapter.Adapter;
import com.example.retrofittraining.model.Country;
import com.example.retrofittraining.model.Countries;
import com.example.retrofittraining.service.HttpService;
import com.example.retrofittraining.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Country> countries;
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    private void getCountries() {

        HttpService httpService = RetrofitInstance.getCountryService();
        Call<Countries> call = httpService.getAll();
        call.enqueue(new Callback<Countries>() {
                @Override
                public void onResponse(Call<Countries> call, Response<Countries> response) {
                    Countries responseBody = response.body();
                    if (responseBody != null && responseBody.getCountryList()!= null){
                        countries = responseBody.getCountryList();
                        viewData();
                    }
                }
                @Override
                public void onFailure(Call<Countries> call, Throwable t) {
                }
        });

    }

    private void viewData() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(countries);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }
}