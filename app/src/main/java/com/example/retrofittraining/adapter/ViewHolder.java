package com.example.retrofittraining.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittraining.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView countryTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        countryTextView = itemView.findViewById(R.id.textView);
    }

    public TextView getCountryTextView() {
        return countryTextView;
    }
}
