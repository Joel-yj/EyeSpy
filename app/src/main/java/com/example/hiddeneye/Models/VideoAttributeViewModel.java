package com.example.hiddeneye.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiddeneye.Repository.VideoAttributeRepository;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

public class VideoAttributeViewModel extends ViewModel {

    private MutableLiveData<List<VideoAttribute>> videoAttributesLiveData;
    private VideoAttributeRepository videoAttributeRepository;

    public VideoAttributeViewModel() throws URISyntaxException, InvalidKeyException {
        videoAttributeRepository = new VideoAttributeRepository();
        videoAttributesLiveData = new MutableLiveData<>();
    }
    public LiveData<List<VideoAttribute>> getVideoAttributes() {
        return videoAttributesLiveData;
    }

    public void loadVideoAttributes() {
        videoAttributeRepository.getVideoAttributes(new VideoAttributeRepository.Callback() {
            @Override
            public void onVideoAttributesLoaded(List<VideoAttribute> videoAttributes) {
                videoAttributesLiveData.setValue(videoAttributes);
            }

            @Override
            public void onError(Exception e) {
                // Handle error
            }
        });
    }


}



