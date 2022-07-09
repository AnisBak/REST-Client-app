package com.example.retrofittraining.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittraining.R;
import com.example.retrofittraining.model.Country;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Country> countries;

    public Adapter(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View viewHolder = layoutInflater.inflate(R.layout.item, parent,false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getCountryTextView().setText(countries.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return countries.size();
    }
}
