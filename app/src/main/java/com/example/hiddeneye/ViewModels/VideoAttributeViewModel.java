package com.example.hiddeneye.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.Repository.VideoAttributeRepository;

import java.util.List;

public class VideoAttributeViewModel extends ViewModel {
    private VideoAttributeRepository videoAttributeRepository;

    public VideoAttributeViewModel(){
        videoAttributeRepository = new VideoAttributeRepository();

    }

    public LiveData<List<VideoAttribute>> getVideoAttributes(){
        return videoAttributeRepository.getVideoAttributesLiveData();
    }

    public void refreshVideoAttributes() {
        videoAttributeRepository.getVideoAttributesFromBlobStorage();
    }



}



