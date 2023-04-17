package com.example.hiddeneye.Activities.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hiddeneye.R;

public class LiveStreamFragment extends Fragment {

    VideoView videoView;
    MediaController mediaController;
    ProgressBar progressBar;
    String URL = "rtsp://zephyr.rtsp.stream/pattern?streamKey=acbf29f8e8ff1e0bd8d6b262092f4c76";


    public LiveStreamFragment() {
        // Required empty public constructor
    }


    public static LiveStreamFragment newInstance(String param1, String param2) {
        LiveStreamFragment fragment = new LiveStreamFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_stream, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        videoView = view.findViewById(R.id.videoView);
//        progressBar = view.findViewById(R.id.progressBar);
//        mediaController = new MediaController(view.getContext());
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        Uri uri = Uri.parse(URL);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                videoView.start();
//                progressBar.setVisibility(View.GONE);
//            }
//        });
    }
}