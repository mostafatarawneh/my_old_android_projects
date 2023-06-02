package com.mos.fulldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView rv ;
DatabaseProject db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv =findViewById(R.id.rec);
        ArrayList<User> arr =new ArrayList<>();
        arr.add(new User(1,"mostafa","000","21","studnet",R.drawable.ic_user));
        arr.add(new User(2,"tarawneh","254956","22","no work",R.drawable.ic_user));
        arr.add(new User(3,"king","079365465","33","Empty",R.drawable.ic_user));
        arr.add(new User(4,"ahmed","465856","45","at compny",R.drawable.ic_user));
        arr.add(new User(5,"ali","hhhhh1111","65","plah",R.drawable.ic_user));
        Adaptore adaptore =new Adaptore(arr);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this,1);
        rv.setAdapter(adaptore);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
    }
}