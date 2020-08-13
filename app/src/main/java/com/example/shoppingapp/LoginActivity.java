package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
EditText enumber,epassword;
TextView txtForget;
Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private  void init()
    {
        enumber=findViewById(R.id.edtnumberL);
        epassword=findViewById(R.id.editpasswordL);
        txtForget=findViewById(R.id.forgottext);
        btnlogin=findViewById(R.id.btnlogin);
    }
}