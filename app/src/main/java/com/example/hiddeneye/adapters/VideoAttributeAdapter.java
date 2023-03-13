package com.example.hiddeneye.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.R;
import com.example.hiddeneye.models.VideoAttribute;

import java.util.List;

public class VideoAttributeAdapter extends RecyclerView.Adapter<VideoAttributeAdapter.ViewHolder> {

    private final List<VideoAttribute> bookList;

    public VideoAttributeAdapter(List<VideoAttribute> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoAttribute book = bookList.get(position);
        holder.titleTextView.setText(book.getVideoPath());
        holder.authorTextView.setText(book.getAge());
        holder.priceTextView.setText(String.valueOf(book.isCarryingBackpack()));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView authorTextView;
        public TextView priceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.col1);
            authorTextView = itemView.findViewById(R.id.col2);
            priceTextView = itemView.findViewById(R.id.col3);
        }
    }
}
