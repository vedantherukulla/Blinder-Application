package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class femaleprofile extends AppCompatActivity {
    ImageView fclcickimage;
    TextView fprotitle,fprodesc,fmore;
    Button selectbtn;

    String data1,data2;
    int myimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_femaleprofile);
        fclcickimage=findViewById(R.id.fclickimage);
        fprotitle=findViewById(R.id.fprotitle);
        fprodesc=findViewById(R.id.fprofdesc);
        selectbtn=findViewById(R.id.selectbtn);
        fmore=findViewById(R.id.txt_more);
        getData();
        setData();
        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnint=new Intent(femaleprofile.this,MovieActivity.class);
                startActivity(btnint);
            }
        });
        fmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(femaleprofile.this, "You've all caught up", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData(){
        if(getIntent().hasExtra("myimage")&&getIntent().hasExtra("data1")&&getIntent().hasExtra("data2"))
        {
            data1=getIntent().getStringExtra("data1");
            data2=getIntent().getStringExtra("data2");
           myimage=getIntent().getIntExtra("myimage",1);

        }else{
            Toast.makeText(femaleprofile.this,"No data to show",Toast.LENGTH_LONG).show();
        }

    }

    private void setData() {

        fprotitle.setText(data1);
        fprodesc.setText(data2);
        fclcickimage.setImageResource(myimage);
    }


}
