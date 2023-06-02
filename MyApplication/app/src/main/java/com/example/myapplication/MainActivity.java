package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc=findViewById(R.id.myrecyclerview);
        rc.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        OnCreatToolsForRecyclerView();
    }// end on creat ()

    public void OnCreatToolsForRecyclerView() {
        ArrayList<Book> arr = new ArrayList<>();
        arr.add(new Book("King","Me","1999"));
        arr.add(new Book("Mostafa","Me","2000"));
        arr.add(new Book("OF cours mostafa","Him","2001"));
        MyAdaptor addp = new MyAdaptor(arr);
        RecyclerView.LayoutManager l= new LinearLayoutManager(this);
        rc.setAdapter(addp);
        rc.setLayoutManager(l);
        rc.setHasFixedSize(true);

    }


}// end class