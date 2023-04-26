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

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;

    RecyclerView chatView;
    EditText messageEditText;
    FloatingActionButton sendButton;
    List<Message> messageList;
    MessageAdapter messageAdapter;

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
        llm.setStackFromEnd(true);
        chatView.setLayoutManager(llm);


        sendButton.setOnClickListener(v -> {
            String question = messageEditText.getText().toString().trim();
            addToChat(question,Message.SENT_BY_USER);
            messageEditText.setText("");

        });



        Intent i = getIntent();
        String text = i.getStringExtra("prompt");
        System.out.println(text);
    }

    void addToChat(String message, String sentBy){
        runOnUiThread(() -> {
            messageList.add(new Message(message,sentBy));
            messageAdapter.notifyDataSetChanged();
            chatView.smoothScrollToPosition(messageAdapter.getItemCount());
        });

    }
}