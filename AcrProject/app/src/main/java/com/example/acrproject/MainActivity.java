package com.example.acrproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView namefirst,namesecond;
    Button b1,b2;
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth=mFirebaseAuth.getInstance();
        namefirst =findViewById(R.id.fname);
        namesecond=findViewById(R.id.sname);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentuser = mFirebaseAuth.getCurrentUser();
                if (currentuser != null) {
                    Toast.makeText(MainActivity.this, "you are logged in", Toast.LENGTH_LONG).show();
                    Intent int1 = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(int1);
                } else {
                    Toast.makeText(MainActivity.this, "login error occured", Toast.LENGTH_LONG).show();
                }
            }
        };
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1= namefirst.getText().toString();
                String s2=namesecond.getText().toString();
                if(s1.isEmpty()){
                    namefirst.setError("UserName is Empty");
                } else if(s2.isEmpty()){
                    namesecond.setError("Password is empty");
                }else if(s1.isEmpty()&&s2.isEmpty()){
                    Toast.makeText(MainActivity.this,"User Name & Password fields are empty",Toast.LENGTH_LONG).show();
                }else if(!(s1.isEmpty()&&s2.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "login error occured", Toast.LENGTH_LONG).show();
                            }else{
                                Intent i =new Intent(MainActivity.this,SecondActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(in);
            }
        });


    }
}
