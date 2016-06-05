package com.example.pockybossuser.sofeed.activities;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.Storage;

public class LoginActivity extends AppCompatActivity {

    private EditText login_edtxt_username;
    private EditText login_edtxt_password;
    private Button login_btn_login;
    private Button login_btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
    }

    private void initComponents() {

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Login");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00E676")));

        login_edtxt_username = (EditText) findViewById(R.id.regis_etxt_username);
        login_edtxt_password = (EditText) findViewById(R.id.regis_etxt_password);
        login_btn_login = (Button) findViewById(R.id.login_btn_login);
        login_btn_register = (Button) findViewById(R.id.login_btn_register);

        login_btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = login_edtxt_username.getText().toString();
                String password = login_edtxt_password.getText().toString();
                if(checkUser(username,password)) {
                    Intent intent = new Intent(LoginActivity.this, FacebookActivity.class);
                    intent.putExtra("User",username);
                    intent.putExtra("Pass",password);
                    startActivity(intent);
                    finish();
                }

            }
        });

        login_btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean checkUser(String username, String password) {
        if(Storage.getInstance().getUser(username,password) == null) {
            System.out.println(username);
            System.out.println(password);
            System.out.println("Wrong User");
            return false;
        }
        System.out.println("Right User");
        return true;
    }
}
