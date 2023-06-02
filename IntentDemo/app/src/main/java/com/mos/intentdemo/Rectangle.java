package com.mos.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rectangle extends AppCompatActivity {
    EditText higth_et,width_et;
    Button calc_btn;
final static int RSQ_RECTANGLE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        higth_et =findViewById(R.id.hight_et);
        width_et= findViewById(R.id.width_et);
        calc_btn =findViewById(R.id.calc_btn);
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hight = Integer.parseInt(higth_et.getText().toString());
                int width = Integer.parseInt(width_et.getText().toString());
                int area = hight * width;
                Intent intent =new Intent();
                intent.putExtra("Rectangle_Area",area);
                setResult(RSQ_RECTANGLE,intent);
                finish();
            }
        });
    }
}