package com.mos.datapersistences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class internalstroge extends AppCompatActivity {
    EditText et_username,et_pass,et_birhtday;
    Button btn_show,btn_save;
    public static final String FILE_NAME = "info";
              // this way use for internal store
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstroge);
        et_username =findViewById(R.id.et_username);
        et_birhtday=findViewById(R.id.et_birthday);
        et_pass =findViewById(R.id.et_password);
        btn_save=findViewById(R.id.btn_sec_save);
        btn_show=findViewById(R.id.btn_sec_show);
      btn_save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
         String username = et_username.getText().toString();
         String password = et_pass.getText().toString();
         String birthday = et_birhtday.getText().toString();
              try {
                  FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
                  PrintWriter pw = new PrintWriter(fos);
                  pw.println("Username : "+username+" Password : "+password+" Birthday : "+birthday);
                  pw.close();
                  fos.close();
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }


          }
      });
      btn_show.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              try {
                  FileInputStream fis = openFileInput(FILE_NAME);
                  InputStreamReader isr = new InputStreamReader(fis);
                  BufferedReader br = new BufferedReader(isr);
                  String temp = "";
                  String alltext= "";
                  while((temp = br.readLine()) !=null){
                      alltext+=temp;

                  }
                  br.close();
                  isr.close();
                  fis.close();
                  Toast.makeText(internalstroge.this, alltext, Toast.LENGTH_SHORT).show();
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }


          }
      });

    }
}