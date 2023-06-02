package com.mos.examlble4adaptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileInformation extends AppCompatActivity {
    EditText et_name,et_followers,et_following,et_posts,et_bio;
    Button done_btn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_information);
        et_bio =findViewById(R.id.et_bio);
        et_followers =findViewById(R.id.et_followers);
        et_following=findViewById(R.id.et_following);
        et_name =findViewById(R.id.et_name);
        et_posts=findViewById(R.id.et_posts);
        done_btn= findViewById(R.id.btn_done);



    }
    public void onClick(View v) {
        int ers,eing,posts;
        ers=Integer.parseInt(et_followers.getText().toString());
        eing=Integer.parseInt(et_following.getText().toString());
        posts=Integer.parseInt(et_posts.getText().toString());
        Intent intent =new Intent();
        intent.putExtra("et_bio",et_bio.getText().toString());
        intent.putExtra("et_posts",posts);
        intent.putExtra("et_followers",ers);
        intent.putExtra("et_following",eing);
        intent.putExtra("et_name",et_name.getText().toString());
        setResult(2, intent);
        finish();
    }
}