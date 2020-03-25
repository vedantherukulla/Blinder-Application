package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CardDetails extends AppCompatActivity {
    TextView payment;
    ImageView img_payment;
    EditText cardname,cardno,cardexp,cardsec;
    Button btn_cardbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        payment=findViewById(R.id.paymethod);
        img_payment=findViewById(R.id.image_payment);
        cardname=findViewById(R.id.cardname);
        cardno=findViewById(R.id.cardid);
        cardexp=findViewById(R.id.no_expiry);
        cardsec=findViewById(R.id.no_cvv);
        btn_cardbook=findViewById(R.id.payment_confirm);
        btn_cardbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booknow=new Intent(CardDetails.this,PaymenySuccess.class);
                startActivity(booknow);
            }
        });
    }
}
