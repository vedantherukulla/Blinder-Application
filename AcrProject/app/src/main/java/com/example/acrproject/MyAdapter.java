package com.example.acrproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[],data2[];
    int images[];
    Context context;

    public MyAdapter(Context ctxt, String s1[],String s2[],int img[]){
    context=ctxt;
    data1=s1;
    data2=s2;
    images=img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.rowfile,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv6.setText(data1[position]);
        holder.tv7.setText(data2[position]);
        holder.myimage.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent fint=new Intent(context,femaleprofile.class);
            fint.putExtra("data1",data1[position]);
            fint.putExtra("data2",data2[position]);
            fint.putExtra("myimage",images[position]);
            context.startActivity(fint);
            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv6,tv7;
        ImageView myimage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv6=itemView.findViewById(R.id.fprofiletext);
            tv7=itemView.findViewById(R.id.desctext);
            myimage=itemView.findViewById(R.id.fimgview);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
