package com.mos.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnx;
    Button btny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnx =findViewById(R.id.btn_x);
        btny =findViewById(R.id.btn_y);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft =fm.beginTransaction();
                FragmentX fragmentX=new FragmentX();
                ft.replace(R.id.fragment_contianner,fragmentX);
                ft.addToBackStack(null);
                ft.commit();
            }
        });  btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft =fm.beginTransaction();
                FragmentY fragmenty=new FragmentY();
                ft.replace(R.id.fragment_contianner,fragmenty);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }
}