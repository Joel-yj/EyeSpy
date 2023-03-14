package com.example.hiddeneye.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.R;
import com.example.hiddeneye.models.VideoAttribute;

import java.util.ArrayList;

public class VideoDataAdapter extends RecyclerView.Adapter<VideoDataAdapter.MyViewHolder> {

    Context context;
    ArrayList<VideoAttribute> list;

    public VideoDataAdapter(Context context, ArrayList<VideoAttribute> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        VideoAttribute videoAttribute = list.get(position);
        holder.videoPath.setText(videoAttribute.getVideoPath());
        holder.age.setText(String.valueOf(videoAttribute.getAge()));
        holder.isCarryingBackpack.setText(videoAttribute.getIsCarryingBackpack());
        holder.isCarryingBag.setText(videoAttribute.getIsCarryingBag());
        holder.lowerBodyClothing.setText(videoAttribute.getLowerBodyClothing());
        holder.lenLowerBodyClothing.setText(videoAttribute.getLenLowerBodyClothing());
        holder.sleeveLength.setText(videoAttribute.getSleeveLength());
        holder.hairLength.setText(videoAttribute.getHairLength());
        holder.isWearingHat.setText(videoAttribute.getIsWearingHat());
        holder.gender.setText(videoAttribute.getGender());
        holder.colorUpperBodyClothing.setText(videoAttribute.getColorUpperBodyClothing());
        holder.colorLowerBodyClothing.setText(videoAttribute.getColorLowerBodyClothing());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView videoPath, age, isCarryingBackpack, isCarryingBag, lowerBodyClothing,lenLowerBodyClothing,sleeveLength,hairLength,isWearingHat,gender,colorUpperBodyClothing,colorLowerBodyClothing;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoPath = itemView.findViewById(R.id.videoPath);
            age = itemView.findViewById(R.id.age);
            isCarryingBackpack = itemView.findViewById(R.id.isCarryingBackpack);
            isCarryingBag = itemView.findViewById(R.id.isCarryingBag);
            lowerBodyClothing = itemView.findViewById(R.id.lowerBodyClothing);
            lenLowerBodyClothing = itemView.findViewById(R.id.lenLowerBodyClothing);
            sleeveLength = itemView.findViewById(R.id.sleeveLength);
            hairLength = itemView.findViewById(R.id.hairLength);
            isWearingHat = itemView.findViewById(R.id.isWearingHat);
            gender = itemView.findViewById(R.id.gender);
            colorUpperBodyClothing = itemView.findViewById(R.id.colorUpperBodyClothing);
            colorLowerBodyClothing = itemView.findViewById(R.id.colorLowerBodyClothing);


        }
    }
}
