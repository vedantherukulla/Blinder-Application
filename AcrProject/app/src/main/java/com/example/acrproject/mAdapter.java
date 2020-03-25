package com.example.acrproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class mAdapter extends RecyclerView.Adapter<mAdapter.MyViewHolder> {
        String data3[],data4[]; //variables to hold the values which we will pass in mainactivity
        int menimage[];
        Context ct;
        public mAdapter(Context ctx,String s3[],String s4[],int image[]){
            ct=ctx;  //storing values inside the constructor
            data3=s3;
            data4=s4;
            menimage=image;
        } //now we can initialise values in fifth activity

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater=LayoutInflater.from(ct);//create layoutinflater object

            View view=inflater.inflate(R.layout.menrowfile,parent,false); //inflate menrowfile xml file and store in view.

            return new MyViewHolder(view); //returns view, oncreateviewholder is connected to myviewholder class, so pass view inside it.
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { //myviewholder is communicating with onbindviewholder

            holder.tv8.setText(data3[position]); //using holdder to set text, and arranging position dynamically
            holder.tv9.setText(data4[position]);
            holder.mimageview.setImageResource(menimage[position]);

        }

        @Override
        public int getItemCount() {
            return menimage.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv8,tv9; //creating textview objects for title n description
            ImageView mimageview; //creating for images
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tv8=itemView.findViewById(R.id.mprofiletext); //finding id's by itemview
                tv9=itemView.findViewById(R.id.mdesctext);
                mimageview=itemView.findViewById(R.id.mimgview);
            }
        }
}
//rowfile xml activity represents each n every row in recycler view