package com.example.hiddeneye.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Adapters.MessageAdapter;
import com.example.hiddeneye.Models.Message;
import com.example.hiddeneye.R;
import com.example.hiddeneye.databinding.ActivityChatBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * The ChatActivity class represents the activity for conducting a chat conversation.
 * It allows the user to send and receive messages in a chat interface
 */
public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;

    RecyclerView chatView;
    EditText messageEditText;
    FloatingActionButton sendButton;
    List<Message> messageList;
    MessageAdapter messageAdapter;

    /**
     * Called when the activity is created. Initializes the activity layout, sets up the chat view,
     * and handles sending messages.
     *
     * @param savedInstanceState The saved instance state Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Set background for activity
        getWindow().setBackgroundDrawableResource(R.drawable.hiddeneye_logo_background);

        messageList = new ArrayList<>();

        chatView = binding.chatview;
        messageEditText = binding.messageEditBox;
        sendButton = binding.sendButton;

        messageAdapter = new MessageAdapter(messageList);
        chatView.setAdapter(messageAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setStackFromEnd(true);
        chatView.setLayoutManager(llm);

        Intent i = getIntent();
        String text = i.getStringExtra("prompt");
        addToChat(text, Message.SENT_BY_USER);


        sendButton.setOnClickListener(v -> {
            String question = messageEditText.getText().toString().trim();
            addToChat(question, Message.SENT_BY_USER);
            messageEditText.setText("");
        });


    }

    /**
     * Adds a new message to the chat conversation.
     *
     * @param message The message to add.
     * @param sentBy  The sender of the message.
     */
    void addToChat(String message, String sentBy) {
        runOnUiThread(() -> {
            messageList.add(new Message(message, sentBy));
            messageAdapter.notifyDataSetChanged();
            chatView.smoothScrollToPosition(messageAdapter.getItemCount());
        });

    }
}