package com.example.acrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ThirdActivity extends AppCompatActivity {
    EditText entername1,entername2,enteremail,enterphn,enterpass;
    Button usernew;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mFirebaseAuth = FirebaseAuth.getInstance();
        entername1=findViewById(R.id.tv1);
        entername2=findViewById(R.id.tv2);
        enteremail=findViewById(R.id.tv3);
        enterphn=findViewById(R.id.tv4);
        enterpass=findViewById(R.id.tv5);
        usernew=findViewById(R.id.btn3);
        usernew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname=entername1.getText().toString();
                String newname2=entername2.getText().toString();
                String newemail=enteremail.getText().toString();
                String newphn=enterphn.getText().toString();
                String newpass=enterpass.getText().toString();
                if(newname.isEmpty()){
                    entername1.setError("First name field is empty");
                }else if(newname2.isEmpty()){
                    entername2.setError("Second name fiels is empty");
                }else if(newname.isEmpty()&&newname2.isEmpty()){
                    Toast.makeText(ThirdActivity.this,"Both first name and second name fields are empty",Toast.LENGTH_LONG).show();
                }else if(newemail.isEmpty()){
                    enteremail.setError("Email field is empty");
                    enteremail.requestFocus();
                }else if(newphn.isEmpty()){
                    enterphn.setError("phone number field is empty");
                    enterphn.requestFocus();
                }else if(newpass.isEmpty()){
                    enterpass.setError("password field is empty");
                    enterpass.requestFocus();
                }else if(newemail.isEmpty()&&newpass.isEmpty()){
                    Toast.makeText(ThirdActivity.this,"email & password fields are empty",Toast.LENGTH_LONG).show();
                }else if(!(newemail.isEmpty()&&newpass.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(newemail,newpass)
                            .addOnCompleteListener(ThirdActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent newintent=new Intent(ThirdActivity.this,MainActivity.class);
                                        startActivity(newintent);
                                    }else{
                                        Toast.makeText(ThirdActivity.this,"Loginerror",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
