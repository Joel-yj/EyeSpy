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

/**
 * Adapter class for binding video attribute data to the RecyclerView in the ExploreFragment.
 */
public class VideoDataAdapter extends RecyclerView.Adapter<VideoDataAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<VideoAttribute> videoAttributeList;

    /**
     * Constructs a new VideoDataAdapter.
     *
     * @param context                  The context.
     * @param videoAttributesArrayList The list of video attributes to display.
     */
    public VideoDataAdapter(Context context, ArrayList<VideoAttribute> videoAttributesArrayList) {
        this.videoAttributeList = videoAttributesArrayList;
        this.context = context;
    }

    /**
     * Creates a new ViewHolder by inflating the layout.
     *
     * @param parent   The parent ViewGroup.
     * @param viewType The type of the view.
     * @return The created ViewHolder.
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attribute_card, parent, false);
        return new MyViewHolder(v);
    }

    /**
     * Binds data to the ViewHolder.
     *
     * @param holder   The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // Set the video attribute data to the views
        VideoAttribute videoAttribute = videoAttributeList.get(position);
        holder.videoPath.setText(videoAttribute.getVideoPath());
        holder.age.setText(String.valueOf(videoAttribute.getAge()));
        holder.isCarryingBackpack.setText(videoAttribute.getIsCarryingBackpack());
        holder.isCarryingBag.setText(videoAttribute.getIsCarryingBag());

        // OnClickListener to handle item click events - Click on ItemCard to display Fullscreen Image
        //TODO To show picture frame of person with card details that is drawn from another container
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageActivity.class);
                context.startActivity(intent);
            }
        });

    }

    /**
     * Returns the number of items in the list.
     *
     * @return The number of items.
     */
    @Override
    public int getItemCount() {
        return videoAttributeList.size();
    }

    /**
     * Updates the video attribute list with new data and notifies the adapter of the changes.
     *
     * @param mVideoAttributes The updated list of video attributes.
     */
    public void updateList(ArrayList<VideoAttribute> mVideoAttributes) {
        this.videoAttributeList = mVideoAttributes;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder class for caching the views of each item in the RecyclerView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView videoPath, age, isCarryingBackpack, isCarryingBag, lowerBodyClothing, lenLowerBodyClothing, sleeveLength, hairLength, isWearingHat, gender, colorUpperBodyClothing, colorLowerBodyClothing;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoPath = itemView.findViewById(R.id.att1);
            age = itemView.findViewById(R.id.att2);
            isCarryingBackpack = itemView.findViewById(R.id.att3);
            isCarryingBag = itemView.findViewById(R.id.att4);
            cardView = itemView.findViewById(R.id.attributeCard);
        }
    }
}
