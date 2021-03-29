package com.example.homework1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondFragment extends BaseFragment {

    private static final String EXTRA_NUMBER = "number";
    private static final String EXTRA_COLOR = "color";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        TextView textView = view.findViewById(R.id.second_fragment_text);
        String text = getArguments().getString(EXTRA_NUMBER);
        int color = getArguments().getInt(EXTRA_COLOR);
        textView.setTextColor(color);

        textView.setText(text);
        return view;
    }



    public static SecondFragment newInstance(String mTitle, int color) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NUMBER, mTitle);
        bundle.putInt(EXTRA_COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }
}
