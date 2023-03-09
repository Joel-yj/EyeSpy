package com.example.hiddeneye.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.R;
import com.example.hiddeneye.models.VideoAttribute;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<VideoAttribute> items;

    public void setItems(List<VideoAttribute> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoAttribute item = items.get(position);
        holder.videoPath.setText(item.getVideoPath());
        holder.age.setText(item.getAge());
        holder.column3TextView.setText(item.isCarryingBackpack());
        holder.column4TextView.setText(item.isCarryingBag());
        holder.column5TextView.setText(item.getLowerBodyClothing());
        holder.column6TextView.setText(item.getLenLowerBodyClothing());
        holder.column7TextView.setText(item.getSleeveLength());
        holder.column8TextView.setText(item.getHairLength());
        holder.column9TextView.setText(item.isWearingHat());
        holder.column10TextView.setText(item.getGender());
        holder.column11TextView.setText(item.getColorUpperBodyClothing());
        holder.column12TextView.setText(item.getColorLowerBodyClothing());

    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView videoPath;
        public TextView age;
        public TextView column3TextView;
        public TextView column4TextView;
        public TextView column5TextView;
        public TextView column6TextView;
        public TextView column7TextView;
        public TextView column8TextView;
        public TextView column9TextView;
        public TextView column10TextView;
        public TextView column11TextView;
        public TextView column12TextView;

        public ViewHolder(View itemView) {
            super(itemView);
            videoPath = itemView.findViewById(R.id.videoPath);
            age = itemView.findViewById(R.id.age);
            column3TextView = itemView.findViewById(R.id.isCarryingBackpack);
            column4TextView = itemView.findViewById(R.id.isCarryingBag);
            column5TextView = itemView.findViewById(R.id.lowerBodyClothing);
            column6TextView = itemView.findViewById(R.id.lenLowerBodyClothing);
            column7TextView = itemView.findViewById(R.id.sleeveLength);
            column8TextView = itemView.findViewById(R.id.hairLength);
            column9TextView = itemView.findViewById(R.id.isWearingHat);
            column10TextView = itemView.findViewById(R.id.gender);
            column11TextView = itemView.findViewById(R.id.colorLowerBodyClothing);
            column12TextView = itemView.findViewById(R.id.colorUpperBodyClothing);
        }
    }
}
