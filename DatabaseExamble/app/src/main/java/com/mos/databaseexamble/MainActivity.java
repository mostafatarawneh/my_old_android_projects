package com.mos.databaseexamble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv ;
    ArrayList<Car> car_arr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler_view);

     //  car_arr.add(new Car("BMW","blue",15));
       //car_arr.add(new Car("mercedes","Black",12.2));
       // car_arr.add(new Car("Lambergene","Green",16.2));

        RecyclyerAdaptoer ra =new RecyclyerAdaptoer(car_arr);
        LinearLayoutManager l = new LinearLayoutManager(this);
        //rv.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(l);
        rv.setAdapter(ra);

    }
}