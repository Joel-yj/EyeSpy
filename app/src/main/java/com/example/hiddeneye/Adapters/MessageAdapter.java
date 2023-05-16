package com.example.hiddeneye.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Models.Message;
import com.example.hiddeneye.R;

import java.util.List;

/**
 * Adapter class for binding chat messages to a RecyclerView in HomeFragment.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    List<Message> messageList;

    /**
     * Constructs a new MessageAdapter.
     *
     * @param messageList The list of chat messages to display.
     */
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
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
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    /**
     * Binds data to the ViewHolder.
     *
     * @param holder   The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message.getSentBy().equals(Message.SENT_BY_USER)){
            holder.leftChatView.setVisibility(View.GONE);
            holder.rightChatView.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(message.getMessage());
        }
        else {
            holder.rightChatView.setVisibility(View.GONE);
            holder.leftChatView.setVisibility(View.VISIBLE);
            holder.leftTextView.setText(message.getMessage());
        }

    }

    /**
     * Returns the number of items in the list.
     *
     * @return The number of items.
     */
    @Override
    public int getItemCount() {
        return messageList.size();
    }

    /**
     * ViewHolder class for caching the views of each item in the RecyclerView.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        LinearLayout leftChatView,rightChatView;
        TextView leftTextView,rightTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView = itemView.findViewById(R.id.left_chat_view);
            rightChatView = itemView.findViewById(R.id.right_chat_view);
            leftTextView = itemView.findViewById(R.id.left_chat_text_view);
            rightTextView=itemView.findViewById(R.id.right_chat_text_view);
        }
    }
}
