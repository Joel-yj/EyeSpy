package com.example.hiddeneye.Activities.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hiddeneye.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class LiveStreamFragment extends Fragment {

    StyledPlayerView playerView;
    ExoPlayer exoPlayer;

    //alvin rtsp
    String URL = "rtsp://10.10.8.171:8554/video_stream";
    //fabian rtsp
//    String URL = "rtsp://10.10.11.214:8554/mystream";

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
        playerView = view.findViewById(R.id.exoplayer);


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

    //TODO find out how to stop the lag and change rgb color
    public void initiliasePlayer() {
        exoPlayer = new ExoPlayer.Builder(getContext()).build();
        playerView.setPlayer(exoPlayer);

        MediaItem mediaItem = new MediaItem.Builder().setUri(URL)
                        .setLiveConfiguration(new MediaItem.LiveConfiguration.Builder().setMaxPlaybackSpeed(1.02f).build()).build();

        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.play();

    }

    @Override
    public void onStart() {
        super.onStart();

        initiliasePlayer();
    }

    @Override
    public void onPause() {
        super.onPause();

        if (exoPlayer == null){
            initiliasePlayer();
        }
    }

}