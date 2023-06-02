package com.example.matrialdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Reg_activtiy extends AppCompatActivity {
    SharedPreferences sp ;
    SharedPreferences.Editor edit;
    EditText et_name,et_email,et_pass;
    Button btn_done_reg;
    MYDatabase db =new MYDatabase(this);
    private final String NAME_KEY="name";
    private final String EMAIL_KEY="email";
    private final String PASS_KEY="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_activtiy);
        sp=getSharedPreferences("Privet_info",MODE_PRIVATE);
         edit =sp.edit();
         et_email = findViewById(R.id.et_email);
         et_name=findViewById(R.id.et_name);
         et_pass=findViewById(R.id.et_pass);
         btn_done_reg=findViewById(R.id.btn_save_Reg);
         btn_done_reg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ArrayList<User> arr = db.GetAllUsers();
                 SaveData();
                 Toast.makeText(Reg_activtiy.this, "Regster Done !", Toast.LENGTH_SHORT).show();
                 Toast.makeText(Reg_activtiy.this, arr.size()+"", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(Reg_activtiy.this,MainActivity.class);
                 //startActivity(intent);
             }
         });

    }//end oncreat()
    public void SaveData(){
       // edit.putString(NAME_KEY,et_name.getText().toString());
        //edit.putString(EMAIL_KEY,et_email.getText().toString());
        //edit.putString(PASS_KEY,et_pass.getText().toString());
        //edit.apply();
        db.InsertUser(new User(et_name.getText().toString(),et_pass.getText().toString()));
    }


}//end class