package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MovieActivity extends AppCompatActivity {
    TextView mvemsg, avengerstxt, jptext;
    ImageView bms, imgavengers, imgjp;
    Button avgrsbtn, jpbtn;
    Button mdate;
    DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        mvemsg = findViewById(R.id.mvemsg);
        avengerstxt = findViewById(R.id.txt_avengers);
        jptext = findViewById(R.id.text_jp);
        bms = findViewById(R.id.bms);
        imgavengers = findViewById(R.id.img_avengers);
        imgjp = findViewById(R.id.img_jp);
        avgrsbtn = findViewById(R.id.btn_avgrs);
        jpbtn = findViewById(R.id.btn_jp);
        mdate = findViewById(R.id.datebtn);
        mdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calender = Calendar.getInstance();
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MovieActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                mdate.setText(date);

            }
        };

        avgrsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verify = mdate.getText().toString();
                if (verify.isEmpty()) {
                    mdate.setError("please choose a date");
                    mdate.requestFocus();
                } else {
                    Intent avgbtn = new Intent(MovieActivity.this, Purchasepage.class);
                    startActivity(avgbtn);

                }
            }

        });
        jpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datec = mdate.getText().toString();
                if (datec.isEmpty()) {
                    Toast.makeText(MovieActivity.this,"select date cannot be empty",Toast.LENGTH_LONG).show();
                    mdate.requestFocus();
                } else {
                    Intent jsp = new Intent(MovieActivity.this, Purchasepage.class);
                    startActivity(jsp);
                }
            }
        });
    }
}
