package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView greeting;
    ImageView b3,b4;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b3=findViewById(R.id.imageview1);
        b4=findViewById(R.id.imageview2);
        greeting=findViewById(R.id.tv);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent women=new Intent(SecondActivity.this,fourthActivity.class);
                startActivity(women);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent men=new Intent(SecondActivity.this,fifthActivity.class);
                startActivity(men);
            }
        });
    }
}
