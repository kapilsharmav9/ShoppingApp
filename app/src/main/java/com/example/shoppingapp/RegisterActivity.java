package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText ename, enumber, epassword;
    Button btnReg;
   ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register() {
        if (ename.getText().equals("") || enumber.getText().equals("") || epassword.getText().equals("")) {
            ename.setError("Please Enter Name");
            ename.requestFocus();
            epassword.setError("Please Enter Password");
            epassword.requestFocus();
            enumber.setError("please Enter Number");
            enumber.requestFocus();
        } else {
            String name = ename.getText().toString();
            if (enumber.length() < 10) {
                Toast.makeText(getApplicationContext(), "Please Enter Valid Number", Toast.LENGTH_SHORT).show();
            }
            String number = enumber.getText().toString();
            String password = epassword.getText().toString();
            progressDialog.setTitle("Create Account");
            progressDialog.setMessage("Please Wait");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            validatephoneNumber(name,number,password);
        }



    }
    private  void validatephoneNumber(final String name, final String number, final String password)
    {final DatabaseReference databaseReference;
    databaseReference= FirebaseDatabase.getInstance().getReference();
    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(!(snapshot.child("users").child("phone").exists()))
            {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("name",name);
                hashMap.put("number,",number);
                hashMap.put("password",password);
                databaseReference.child("users").child("phone").updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Account Created ", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

    }

    private void init() {
        ename = findViewById(R.id.editNameR);
        enumber = findViewById(R.id.edtnumberR);
        epassword = findViewById(R.id.editpasswordR);
        btnReg = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(RegisterActivity.this);
    }
}