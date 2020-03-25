package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class fifthActivity extends AppCompatActivity {
    RecyclerView recycler;
    String s3[],s4[];
    int menimages[]={R.drawable.ranbirkapoor,R.drawable.karthikaaryan,R.drawable.martingarix,R.drawable.ntr,R.drawable.prabhas,
            R.drawable.calvinharris,R.drawable.edsheeran,R.drawable.drake,R.drawable.postmalone,R.drawable.dylanminnette};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
         recycler=findViewById(R.id.recycle_male);
          s3=getResources().getStringArray(R.array.Male_Profiles);
          s4=getResources().getStringArray(R.array.Male_Description);
          // in onCreate method we intialise new class and create mAdapter object here and pass 4 parameters
          MyAdapter mAdapter=new MyAdapter(this,s3,s4,menimages);

          recycler.setAdapter(mAdapter);
          recycler.setLayoutManager(new LinearLayoutManager(this));



    }
}
