package com.mos.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager ;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.main_viewpager);
        tableLayout=findViewById(R.id.main_tablayout);

    }
}