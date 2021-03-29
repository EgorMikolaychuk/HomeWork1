package com.example.homework1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_container);
        if(savedInstanceState == null)
            ToggleState();

    }


    private void ToggleState() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment recycler_container = getSupportFragmentManager().findFragmentById(R.id.recycler_container);
        transaction.add(R.id.recycler_container, new RecyclerFragment());
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

}