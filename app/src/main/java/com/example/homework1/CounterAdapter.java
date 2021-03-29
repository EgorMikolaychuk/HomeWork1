package com.example.homework1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CounterAdapter extends RecyclerView.Adapter<CounterViewHolder> {

    List<CounterModel> data = DataSource.getInstance().getRemoteData();


    @NonNull
    @Override
    public CounterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.counter_item, parent,false);
        return new CounterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CounterViewHolder holder, int position) {
        CounterModel model = data.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void insert() {
        int color;
        int num = getItemCount() + 1;
        if (num%2 == 0)
            color = Color.RED;
        else
            color = Color.BLUE;
        String Title = Integer.toString(num);
        CounterModel newData = new CounterModel(Title, color);
        data.add(newData);
        notifyItemInserted(data.size() - 1);
    }
}
