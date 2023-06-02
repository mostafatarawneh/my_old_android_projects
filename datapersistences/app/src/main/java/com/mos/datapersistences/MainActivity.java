package com.mos.datapersistences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_save,btn_show;
    EditText et_data;
    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_save = findViewById(R.id.btn_save);
        btn_show = findViewById(R.id.btn_show);
        et_data = findViewById(R.id.et_data);
        sp = getSharedPreferences("Emails",MODE_PRIVATE);
        edit = sp.edit();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString("name",et_data.getText().toString());
                edit.apply();
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = sp.getString("name","Not Found !");
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }//end onCreat()
}// end class