package com.example.evgeniy.technotest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.fragment_place, new MainFragment()).commit();
        }
    }
}
