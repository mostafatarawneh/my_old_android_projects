package com.example.recyclerdemoaga;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecActivity extends AppCompatActivity {
        RecyclerView rv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secactivity);
        rv = findViewById(R.id.rv_rv);
        ArrayList<Contries> arr =new ArrayList<>();
        arr.add(new Contries("Mostafa"));
        arr.add(new Contries("Tarawneh"));
        arr.add(new Contries("Ahmed"));
        arr.add(new Contries("Ali"));
   Radaptore myadaptor = new Radaptore(arr);
        LinearLayoutManager llm =new GridLayoutManager(this,2);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(myadaptor);
        rv.addItemDecoration(new DividerItemDecoration(this,GridLayoutManager.VERTICAL));

    }
}
