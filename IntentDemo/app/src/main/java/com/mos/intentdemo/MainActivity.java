package com.mos.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int REQ_TRIANGEL_CODE = 2;
    final static int REQ_RECTANGLE_CODE= 1;
    EditText et,et_phone;
    Button btn,bnt2;
    Button rectangle_btn,triangle_btn,go_cap_btn;
    TextView tv_reuslt_IntentDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et =findViewById(R.id.ui_et);
        btn=findViewById(R.id.btn);
        et_phone =findViewById(R.id.et_phone);
        bnt2=findViewById(R.id.btn_Dail);
        rectangle_btn = findViewById(R.id.btn_rectangle);
        triangle_btn = findViewById(R.id.btn_triangle);
        rectangle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Rectangle.class);
                startActivityForResult(intent,REQ_RECTANGLE_CODE);
            }
        });
        triangle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Triangle.class);
                startActivityForResult(intent,REQ_TRIANGEL_CODE);
            }
        });
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dail = new Intent();
                intent_dail.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+et_phone.getText().toString());
                intent_dail.setData(uri);
                startActivity(intent_dail);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),IntentDemo.class);
                intent.putExtra("key",et.getText().toString());
                startActivity(intent);

            }
        });
        go_cap_btn=findViewById(R.id.take_photo_btn);
        go_cap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getBaseContext(),CaptureActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            String oldText;
            int newText;
            double newDtext;
            if (requestCode == REQ_RECTANGLE_CODE) {
                oldText = tv_reuslt_IntentDemo.getText().toString();
                newText = data.getIntExtra("Rectangle_Area", 0);
                tv_reuslt_IntentDemo.setText(oldText + "\n" + newText);

            } else if (requestCode == REQ_TRIANGEL_CODE) {
                oldText = tv_reuslt_IntentDemo.getText().toString();
                newDtext = data.getDoubleExtra("Triangle_Area", 1.2);
                tv_reuslt_IntentDemo.setText(oldText + "\n" + newDtext);
            }
        } catch (Exception e) {
            tv_reuslt_IntentDemo.setText(e.getMessage());
        }
    }
}

