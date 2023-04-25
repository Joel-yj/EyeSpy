package com.example.hiddeneye.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.R;
import com.example.hiddeneye.databinding.ActivityChatBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;

    RecyclerView chatView;
    EditText messageEditText;
    FloatingActionButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chatView = binding.chatview;
        messageEditText = binding.messageEditBox;
        sendButton = binding.sendButton;
        //Set background for chat
        getWindow().setBackgroundDrawableResource(R.drawable.hiddeneye_logo_background) ;


        Intent i = getIntent();
        String text = i.getStringExtra("prompt");
        System.out.println(text);
    }
}