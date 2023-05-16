package com.example.hiddeneye.Activities.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hiddeneye.Activities.ChatActivity;
import com.example.hiddeneye.databinding.FragmentHomeBinding;


/**
 * The HomeFragment class represents a fragment that displays the home screen of the application.
 * It allows the user to enter a chat prompt and navigate to the ChatActivity for chat.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    /**
     * Default constructor for the HomeFragment.
     */
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    //TODO Implement openAI langchain algo from django webApp
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageButton send = binding.sendButton;
        send.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), ChatActivity.class);
            i.putExtra("prompt", binding.chatbox.getText().toString());
            startActivity(i);
        });
    }
}