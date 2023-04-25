package com.example.hiddeneye.Activities.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.hiddeneye.Activities.ChatActivity;
import com.example.hiddeneye.R;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    //TODO Implement openAI langchain interface
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        EditText chatbox = view.findViewById(R.id.chatbox);

        chatbox.setOnTouchListener((v, event) -> {

            if (event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (chatbox.getRight() - chatbox.getCompoundDrawables()[2].getBounds().width())) {
                    // your action here
                    Intent i = new Intent(getActivity(),ChatActivity.class);
                    i.putExtra("prompt",chatbox.getText().toString());
                    startActivity(i);

                    return true;
                }
            }
            return false;
        });

        return view;

    }
}