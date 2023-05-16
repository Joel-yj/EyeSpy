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

/**
 * The LiveStreamFragment class that displays a live stream video from an edge device.
 * It uses ExoPlayer library to play the video stream.
 */
public class LiveStreamFragment extends Fragment {

    StyledPlayerView playerView;
    ExoPlayer exoPlayer;

    //alvin rtsp
    String URL = "rtsp://10.10.8.171:8554/video_stream";
    //fabian rtsp
//    String URL = "rtsp://10.10.11.214:8554/mystream";

    /**
     * Default constructor for the LiveStreamFragment.
     */
    public LiveStreamFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_stream, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerView = view.findViewById(R.id.exoplayer);


    }

    /**
     * Initializes and starts the ExoPlayer to play the live stream video.
     */
    //TODO find out how to stop the lag and change rgb color
    public void initiliasePlayer() {
        exoPlayer = new ExoPlayer.Builder(getContext()).build();
        playerView.setPlayer(exoPlayer);

        MediaItem mediaItem = new MediaItem.Builder().setUri(URL).setLiveConfiguration(new MediaItem.LiveConfiguration.Builder().setMaxPlaybackSpeed(1.02f).build()).build();

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

        if (exoPlayer == null) {
            initiliasePlayer();
        }
    }

}