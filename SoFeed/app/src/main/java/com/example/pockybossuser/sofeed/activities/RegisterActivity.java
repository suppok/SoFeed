package com.example.pockybossuser.sofeed.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.Storage;
import com.example.pockybossuser.sofeed.models.User;
import com.example.pockybossuser.sofeed.models.facebook.FacebookAccount;

public class RegisterActivity extends AppCompatActivity {

    private EditText regis_etxt_username;
    private EditText regis_etxt_password;
    private EditText regis_etxt_confirmPass;
    private EditText edtxt_facebook_username;
    private EditText edtxt_facebook_password;
    private EditText edtxt_twitter_username;
    private EditText edtxt_twitter_password;
    private EditText edtxt_instagram_username;
    private EditText edtxt_instagram_password;

    private Button regis_btn_save;
    private Button regis_btn_cancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
    }

    private void initComponents() {

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Register");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00E676")));

        regis_etxt_username = (EditText) findViewById(R.id.regis_etxt_username);
        regis_etxt_password = (EditText) findViewById(R.id.regis_etxt_password);
        regis_etxt_confirmPass = (EditText) findViewById(R.id.regis_edt_confirmPass);
        edtxt_facebook_username = (EditText) findViewById(R.id.edtxt_facebook_username);
        edtxt_facebook_password = (EditText) findViewById(R.id.edtxt_facebook_password);
        edtxt_twitter_username = (EditText) findViewById(R.id.edtxt_twitter_username);
        edtxt_twitter_password = (EditText) findViewById(R.id.edtxt_twitter_password);
        edtxt_instagram_username = (EditText) findViewById(R.id.edtxt_instagram_username);
        edtxt_instagram_password = (EditText) findViewById(R.id.edtxt_instagram_password);

        regis_btn_save = (Button) findViewById(R.id.regis_btn_save);
        regis_btn_cancel = (Button) findViewById(R.id.regis_btn_cancel);

        regis_btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(regis_etxt_password.getText().toString().equals(regis_etxt_confirmPass.getText().toString())) {
                    User user = new User(regis_etxt_username.getText().toString() , regis_etxt_password.getText().toString());
                    user.setFacebookAccountById(edtxt_facebook_username.getText().toString(), edtxt_facebook_password.getText().toString());
                    user.setTwitterAccountById(edtxt_twitter_username.getText().toString(), edtxt_twitter_password.getText().toString());
                    user.setInstagramAccountById(edtxt_instagram_username.getText().toString(), edtxt_instagram_password.getText().toString());
                    Storage.getInstance().addUser(user);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    Toast.makeText(RegisterActivity.this, "Regis successful", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }
                else {
                    AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Your password do not match with confirm password");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        regis_btn_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
