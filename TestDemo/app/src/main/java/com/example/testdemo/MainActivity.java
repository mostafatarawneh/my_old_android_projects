package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Atxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.table_layout_train);
         Atxt = findViewById(R.id.textViewA);


    }// end onCreate()

    public void GotoGrid(View view) {
        Intent intent = new Intent(this,GridView.class);
        startActivity(intent);

    }




}// end class