package com.mos.cardviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView ls;
    CardView cv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_row);
        ls=findViewById(R.id.list_view);
        ArrayList<CardViewExam> cve =new ArrayList<>();
        cve.add(new CardViewExam(R.drawable.nnn,"hello my heart"));
        cve.add(new CardViewExam(R.drawable.nnn,"mostafa Tarawneh"));
        cve.add(new CardViewExam(R.drawable.nnn,"Saw math1"));
        CustomAdaptor ca=new CustomAdaptor(getApplicationContext(),cve);
        ls.setAdapter(ca);
        cv = findViewById(R.id.card_view);
       ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0:
                       Toast.makeText(getBaseContext(),"hi",Toast.LENGTH_SHORT).show();
                       break;
                   case 1 :
                       Toast.makeText(getBaseContext(),"two",Toast.LENGTH_SHORT).show();
                       break;
                   case 2:
                       Toast.makeText(getBaseContext(),"there",Toast.LENGTH_SHORT).show();
                       break;
               }
           }
       });
       registerForContextMenu(ls);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.notification :
                SnackbarReady("this is notification","undo");
                break;
            case R.id.about_us :
                Toast.makeText(getApplicationContext(),"I am mostafa welcome BB",Toast.LENGTH_SHORT).show();
                break;
        }
      return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.about_us :
                Toast.makeText(getBaseContext(),"hi",Toast.LENGTH_SHORT).show();
              return true;
        }
        return false;
    }


    public void CustomMessage(String s){
        View v = getLayoutInflater().inflate(R.layout.custom_toast,null,false);
        TextView tv = v.findViewById(R.id.custom_toast_tv);
        tv.setText(s);
        Toast toast = new Toast(getBaseContext());
        toast.setView(v);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    public void SnackbarReady(String maintext,String btnName){
        Snackbar sn =Snackbar.make(ls,maintext,Snackbar.LENGTH_LONG);
        sn.setAction(btnName, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMessage("hi from my Snackbar");
            }
        });
        sn.show();
    }
}