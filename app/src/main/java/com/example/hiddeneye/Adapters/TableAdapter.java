package com.example.hiddeneye.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.R;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    Context context;
    List<VideoAttribute> videoAttributeList;


    public TableAdapter(Context context, List<VideoAttribute> videoAttributeList) {
        this.context = context;
        this.videoAttributeList = videoAttributeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (videoAttributeList != null && videoAttributeList.size()>0){
            VideoAttribute videoAttribute = videoAttributeList.get(position);
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


        }else{
            return;
        }

    }

    @Override
    public int getItemCount() {

        return videoAttributeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView videoPath, age, isCarryingBackpack, isCarryingBag, lowerBodyClothing,lenLowerBodyClothing,sleeveLength,hairLength,isWearingHat,gender,colorUpperBodyClothing,colorLowerBodyClothing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoPath = itemView.findViewById(R.id.col1);
            age = itemView.findViewById(R.id.col2);
            isCarryingBackpack = itemView.findViewById(R.id.col3);
            isCarryingBag = itemView.findViewById(R.id.col4);
            lowerBodyClothing = itemView.findViewById(R.id.col5);
            lenLowerBodyClothing = itemView.findViewById(R.id.col6);
            sleeveLength = itemView.findViewById(R.id.col7);
            hairLength = itemView.findViewById(R.id.col8);
            isWearingHat = itemView.findViewById(R.id.col9);
            gender = itemView.findViewById(R.id.col10);
            colorUpperBodyClothing = itemView.findViewById(R.id.col11);
            colorLowerBodyClothing = itemView.findViewById(R.id.col12);


        }
    }
}
