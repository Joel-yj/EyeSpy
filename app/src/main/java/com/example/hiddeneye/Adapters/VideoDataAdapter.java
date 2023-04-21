package com.example.hiddeneye.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Activities.ImageActivity;
import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.R;

import java.util.ArrayList;

public class VideoDataAdapter extends RecyclerView.Adapter<VideoDataAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<VideoAttribute> videoAttributeList;
    public VideoDataAdapter(Context context, ArrayList<VideoAttribute> videoAttributesArrayList) {
        this.videoAttributeList = videoAttributesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attribute_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        VideoAttribute videoAttribute = videoAttributeList.get(position);
        holder.videoPath.setText(videoAttribute.getVideoPath());
        holder.age.setText(String.valueOf(videoAttribute.getAge()));
        holder.isCarryingBackpack.setText(videoAttribute.getIsCarryingBackpack());
        holder.isCarryingBag.setText(videoAttribute.getIsCarryingBag());

        //TODO To show picture frame of person with card details that is drawn from another container
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoAttributeList.size();
    }

    public void updateList(ArrayList<VideoAttribute> mVideoAttributes){
        this.videoAttributeList = mVideoAttributes;
        notifyDataSetChanged();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView videoPath, age, isCarryingBackpack, isCarryingBag, lowerBodyClothing,lenLowerBodyClothing,sleeveLength,hairLength,isWearingHat,gender,colorUpperBodyClothing,colorLowerBodyClothing;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoPath = itemView.findViewById(R.id.att1);
            age = itemView.findViewById(R.id.att2);
            isCarryingBackpack = itemView.findViewById(R.id.att3);
            isCarryingBag = itemView.findViewById(R.id.att4);
            cardView =  itemView.findViewById(R.id.attributeCard);
        }
    }
}
