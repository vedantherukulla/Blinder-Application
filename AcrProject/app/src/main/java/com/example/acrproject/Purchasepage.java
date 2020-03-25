package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Purchasepage extends AppCompatActivity {

    TextView seats,tktprice,totalprice,taxttl,totalseats,subttl,tax,amnt;
    Button purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasepage);
        seats=findViewById(R.id.no_seats);
        tktprice=findViewById(R.id.price_tkt);
        totalprice=findViewById(R.id.price_totl);
        taxttl=findViewById(R.id.tax_no);
        tax=findViewById(R.id.ttl_tax);
        subttl=findViewById(R.id.ttl_sub);
        amnt=findViewById(R.id.ttl_amnt);
        totalseats=findViewById(R.id.ttlseats);

        purchase=findViewById(R.id.btn_prchse);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent purchase=new Intent(Purchasepage.this,CardDetails.class);
                startActivity(purchase);
            }
        });

    }}

