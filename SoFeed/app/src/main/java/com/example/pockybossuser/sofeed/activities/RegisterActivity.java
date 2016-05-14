package com.example.pockybossuser.sofeed.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pockybossuser.sofeed.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView regis_tv_username;
    private EditText regis_etxt_username;
    private TextView regis_tv_password;
    private EditText regis_etxt_password;
    private TextView regis_tv_confirmPass;
    private EditText regis_etxt_confirmPass;
    private TextView regis_tv_fbAccount;
    private Button regis_btn_loginFB;
    private Button regis_btn_save;
    private Button regis_btn_cancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
    }

    private void initComponents() {

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00E676")));

        regis_etxt_username = (EditText) findViewById(R.id.regis_etxt_username);
        regis_etxt_password = (EditText) findViewById(R.id.regis_etxt_password);
        regis_etxt_confirmPass = (EditText) findViewById(R.id.regis_edt_confirmPass);
        regis_btn_loginFB = (Button) findViewById(R.id.regis_btn_loginFB);
        regis_btn_save = (Button) findViewById(R.id.regis_btn_save);
        regis_btn_cancel = (Button) findViewById(R.id.regis_btn_cancel);

        regis_btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        regis_btn_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
