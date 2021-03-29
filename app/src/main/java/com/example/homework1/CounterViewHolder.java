package com.example.homework1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CounterViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;

    public CounterViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.counter_title);
    }

    @SuppressLint("SetTextI18n")
    public void bind(CounterModel model){
        title.setText(model.mTitle);
        title.setTextColor(model.mFontColor);
        title.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment recycler_container = activity.getSupportFragmentManager().findFragmentById(R.id.recycler_container);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .remove(recycler_container)
                    .add(R.id.recycler_container, SecondFragment.newInstance(model.mTitle, model.mFontColor))
                    .addToBackStack(null)
                    .commit();

        });
    }

}
