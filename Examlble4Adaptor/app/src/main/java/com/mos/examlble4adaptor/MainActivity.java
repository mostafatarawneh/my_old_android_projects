package com.mos.examlble4adaptor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    ListView lv;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_main);
        lv=findViewById(R.id.lv_profile);
        btn_add=findViewById(R.id.btn_add);
        ArrayList<Pofile> info = new ArrayList<>();


        //     btn_add.setOnClickListener(new View.OnClickListener() {
          //      @Override
            //    public void onClick(View v) {
              //      Intent intent=new Intent(getBaseContext(),ProfileInformation.class);
             //       startActivityForResult(intent,1);            }
           // });

       //info.add(new Pofile("mostafa","hello",155,22,14,R.drawable.ic_user));
       //info.add(new Pofile("Tarawneh","king",255,27,10,R.drawable.ic_user));
       //info.add(new Pofile("abed","Love",177,62,82,R.drawable.ic_user));
         // CustomAdaptor ca=new CustomAdaptor(info, getBaseContext());
       //lv.setAdapter(ca);






    }
}