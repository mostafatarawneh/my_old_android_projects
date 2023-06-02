package com.mos.tar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mos.com.R;
import com.mos.tar.DataBaseStuff.LoginDataBaseAdapter;

public class MainActivity extends Activity {
    Button btnSignIn, btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // create a instance of SQLite Database
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get The Reference Of Buttons
        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);

        //check if the user is registered in the database
        if (loginDataBaseAdapter.isNotEmpty()) {
            btnSignUp.setVisibility(View.GONE);
        }

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO : add here advertisement

                /// Create Intent for SignUpActivity abd Start The Activity
                Intent intent = new Intent(com.mos.tar.MainActivity.this, SignUPActivity.class);
                startActivity(intent);

            }
        });
    }

    // Methos to handleClick Event of Sign In Button
    public void signIn(View V) {
        final Dialog dialog = new Dialog(com.mos.tar.MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the Refferences of views
        final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //TODO : add here advertisement

                // get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with Password entered by user
                if (password.equals(storedPassword)) {
                    loginDataBaseAdapter.close();
                    Toast.makeText(com.mos.tar.MainActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    Intent intent = new Intent(com.mos.tar.MainActivity.this, com.mos.tar.debt_page.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(com.mos.tar.MainActivity.this, "كلمة المرور او المستخدم غير صحيحة", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}