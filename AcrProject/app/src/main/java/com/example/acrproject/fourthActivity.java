package com.example.acrproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class fourthActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.kajal,R.drawable.kristianstewart,R.drawable.anushka,R.drawable.billiellish,R.drawable.poojahegde,
            R.drawable.dualipa,R.drawable.nayantara,R.drawable.selena,R.drawable.emmawatson,R.drawable.jenniferlawrence};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        recyclerView = findViewById(R.id.recycle_female);
        s1=getResources().getStringArray(R.array.Female_Profiles);
        s2=getResources().getStringArray(R.array.Description);
        MyAdapter myAdapter=new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
