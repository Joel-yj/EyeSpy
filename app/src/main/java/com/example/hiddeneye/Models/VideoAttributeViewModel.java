package com.example.hiddeneye.Models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hiddeneye.Repository.VideoAttributeRepository;

import java.util.List;

public class VideoAttributeViewModel extends AndroidViewModel {

    private VideoAttributeRepository mRepository;
    private LiveData<List<VideoAttribute>> mVideoAttributes;


    public VideoAttributeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VideoAttributeRepository(application);
        mVideoAttributes = mRepository.getVideoAttributes();
    }
    public LiveData<List<VideoAttribute>> getVideoAttributes(){
        return mVideoAttributes;
    }
}
