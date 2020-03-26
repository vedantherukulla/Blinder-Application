package com.example.acrproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Purchasepage extends AppCompatActivity {
    EditText seat;
    TextView t1,t2,t3;
    Button btn,cnfm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasepage);
        btn=findViewById(R.id.button);
        cnfm=findViewById(R.id.btn_cnfm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat=findViewById(R.id.editText2);
                t1=findViewById(R.id.textView10);
                t2=findViewById(R.id.textView2);
                t3=findViewById(R.id.textView3);
                String seatnumber=seat.getText().toString();
                double sub=(Double.parseDouble(seatnumber)*20);
                t1.setText("Sub Total :"+String.valueOf(sub));
                double tax= ((sub*20)/100);
                t2.setText("Tax :"+String.valueOf(tax));
                double ttl=sub+tax;
                t3.setText("Total Price :"+String.valueOf(ttl));

            }
        });
        cnfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pur=new Intent(Purchasepage.this,CardDetails.class);
                startActivity(pur);
            }
        });


    }
}