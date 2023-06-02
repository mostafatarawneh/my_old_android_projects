package com.mos.datapersistences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExternalStorge extends AppCompatActivity {
    Button btn_save,btn_showw;
    EditText et_username,et_password,et_birhtday;
    String [] permisstions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
   private final static int PERMISSTIONS_KEY =1;
    public static final String FILE_NAME = "king";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storge);
        btn_save = findViewById(R.id.btn_external_save);
        btn_showw = findViewById(R.id.btn_extenal_show);
        et_birhtday=findViewById(R.id.et_external_birthday);
        et_password=findViewById(R.id.et_external_password);
        et_username=findViewById(R.id.et_extrenal_username);
        // طريقة اخذ  الصلاحيه
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,permisstions,PERMISSTIONS_KEY);


        } else {
            ActivityCompat.requestPermissions(this,permisstions,PERMISSTIONS_KEY);
        } // end if permisstions
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String brtihdate = et_birhtday.getText().toString();
                try {

                if (isEternalWriteable()){
                    File ex_file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File f = new File(ex_file,FILE_NAME);
                    f.createNewFile();
                    FileOutputStream fos = new FileOutputStream(f,true);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println("Username : "+username);
                    pw.println("Password : "+password);
                    pw.println("Birthdate : "+brtihdate);
                    if(pw.checkError()){
                        Toast.makeText(ExternalStorge.this, "Error", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ExternalStorge.this, "NO Error", Toast.LENGTH_SHORT).show();

                    }
                    pw.close();
                    fos.close();
                    Toast.makeText(ExternalStorge.this, "Saved is done for "+username+password+brtihdate, Toast.LENGTH_SHORT).show();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        btn_showw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis =  openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    String temp = "";
                    String allText = "";
                    while ((temp=br.readLine())!= null){
                     allText += temp;
                    }
                    br.close();
                    isr.close();
                    fis.close();
                    Toast.makeText(ExternalStorge.this, allText, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }//end on create();

    public boolean isEternalWriteable(){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }// end isEternalWriteable()

    public boolean isEternalReadable(){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED) || state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            return true;
        }
        return false;
    }// end isEternalMounted()

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSTIONS_KEY :
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "تم اخذ الصلاحيه", Toast.LENGTH_SHORT).show();
                }
        }        return;
    }
}//end class