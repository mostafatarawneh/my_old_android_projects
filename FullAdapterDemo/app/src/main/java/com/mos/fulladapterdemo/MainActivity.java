package com.mos.fulladapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= findViewById(R.id.test_listview);
        ArrayList<String> contry = new ArrayList<>();
        contry.add("Mostafa");
        contry.add("Tarawneh");
        contry.add("Anas");
        contry.add("SAw");
        contry.add("Jordan");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contry);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Toast.makeText(getBaseContext(),"Mostafa",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(),"Tarawneh",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(),"Anas",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void GoToCustomAdpator(View v){
        Intent intent = new Intent(getBaseContext(),CustomadpDemo.class);
        startActivity(intent);

    }
}