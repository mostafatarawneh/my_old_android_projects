package com.example.recyclerdemoaga;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp = findViewById(R.id.main_sp_area);
        EditText hight_et =findViewById(R.id.hight_et);
        EditText width_et=findViewById(R.id.width_et);
        EditText raidus = findViewById(R.id.radius_et);
        Button cal_btn=findViewById(R.id.button);
        TextView reuslt_tv=findViewById(R.id.reuslt);

    }
}