package com.example.homework1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private final List<CounterModel> mData;
    private static DataSource sInstance;

    public DataSource() {
        mData = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            String title = Integer.toString(i+1);
            int color;
            if (i%2 == 0)
                color = Color.BLUE;
            else
                color = Color.RED;
            mData.add(new CounterModel(title,color));
        }
    }

    public List<CounterModel> getRemoteData(){
        return mData;
    }

    public synchronized static DataSource getInstance(){
        if (sInstance == null) {
            sInstance = new DataSource();
        }
        return sInstance;
    }
}
