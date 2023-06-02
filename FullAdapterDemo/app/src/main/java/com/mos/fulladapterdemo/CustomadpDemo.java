package com.mos.fulladapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomadpDemo extends AppCompatActivity {
    ListView lv;
    Button add_btn;
    EditText et_add;
    int currnetPostion=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customadp_demo);
        lv = findViewById(R.id.custm_listview);
        add_btn=findViewById(R.id.btn_add_item);
        et_add=findViewById(R.id.et_list_add);
        ArrayList<String> data =new ArrayList<>();
        CustomAdaptor ca = new CustomAdaptor(data,this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String s= (String)ca.getItem(position);
                et_add.setText(s);
                currnetPostion=position;
                add_btn.setText("Edit");
            }
        });


        lv.setAdapter(ca);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currnetPostion >= 0) {

                  // Edit
                    ca.editItem(currnetPostion,et_add.getText().toString());
                    et_add.setText("");
                    currnetPostion=-1;
                    add_btn.setText("ADD");
                }else {

                    ca.addItem(et_add.getText().toString());
                    et_add.setText("");

                }

               ca.notifyDataSetChanged();
            }
        });
    }

}