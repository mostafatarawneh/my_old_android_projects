package com.mos.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Triangle extends AppCompatActivity {
    EditText higth_et,base_et;
    Button calu_tri_btn;
    final static  int RSQ_TRIANGLE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        higth_et =findViewById(R.id.hight_triangle_et);
        base_et = findViewById(R.id.base_et);
        calu_tri_btn =findViewById(R.id.calc_tri_btn);
        calu_tri_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    int hight = Integer.parseInt(higth_et.getText().toString());
                    int base = Integer.parseInt(base_et.getText().toString());
                    double area = 0.5 * hight * base;
                    Intent intent = new Intent();
                    intent.putExtra("Triangle_Area", area);
                    setResult(RSQ_TRIANGLE, intent);
                    finish();

                } catch (Exception e) {

                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void backMethod(View v){
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}