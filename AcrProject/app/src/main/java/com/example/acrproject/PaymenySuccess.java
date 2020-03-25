package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymenySuccess extends AppCompatActivity {
    TextView paysuccess;
    Button finish,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymeny_success);
        paysuccess=findViewById(R.id.success_pay);
        finish=findViewById(R.id.btn_rtn);
        cancel=findViewById(R.id.btn_cancel);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finish=new Intent(PaymenySuccess.this,MovieActivity.class);
                startActivity(finish);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymenySuccess.this,"Your booking is cancelled",Toast.LENGTH_LONG).show();
            }
        });

    }
}
