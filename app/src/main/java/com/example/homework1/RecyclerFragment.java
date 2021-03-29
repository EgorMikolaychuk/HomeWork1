package com.example.homework1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerFragment extends BaseFragment{

    private RecyclerView recyclerView;
    CounterAdapter adapter = new CounterAdapter();
    int columns;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.CounterFeed);
        recyclerView.setItemViewCacheSize(10);
        Context applicationContext = recyclerView.getContext().getApplicationContext();
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == 1)
            columns = 3;
        else
            columns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(applicationContext, columns));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.CounterButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.insert();
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numbers", adapter.data.size());
    }

}
