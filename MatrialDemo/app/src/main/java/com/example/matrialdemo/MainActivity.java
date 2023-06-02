package com.example.matrialdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp ;
    EditText usr,pass;
MYDatabase database = new MYDatabase(getApplicationContext());
//ArrayList<User> arr_user = database.GetAllUsers();
    Button btn_login,btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("Privet_info",MODE_PRIVATE);
         btn_login =findViewById(R.id.button);
        usr = findViewById(R.id.username_et);
        pass = findViewById(R.id.password_et);
        btn_reg=findViewById(R.id.btn_goto_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Reg_activtiy.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  User user=arr_user.get(0);
               // String name = sp.getString("name","mos");
                //String passw = sp.getString("password","mos");
               // if(user.getName().equals(usr.getText().toString())&&user.getPass().equals(pass.getText().toString())){
               // if(usr.getText().toString().equals(name)&&pass.getText().toString().equals(passw)) {
                   // Toast.makeText(MainActivity.this, name+" | "+passw, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Privte_activ.class);
                    startActivity(intent);
                  //  for (User user1 :arr_user){
                       // Log.d("User"+user1.getId(),user1.getName()+ " " +user1.getPass());
                    //}
              //  }else{

                      Toast.makeText(getBaseContext(),"Access Denied !",Toast.LENGTH_LONG).show();
                }
         //   }
        });
    }
}