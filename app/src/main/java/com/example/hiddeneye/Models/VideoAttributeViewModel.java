package com.example.hiddeneye.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiddeneye.Repository.VideoAttributeRepository;
import com.microsoft.azure.storage.StorageException;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

public class VideoAttributeViewModel extends ViewModel {
    private VideoAttributeRepository videoAttributeRepository;

    public VideoAttributeViewModel() throws URISyntaxException, InvalidKeyException, StorageException {
        videoAttributeRepository = new VideoAttributeRepository();

    }

    public LiveData<List<VideoAttribute>> getVideoAttributes(){
        return videoAttributeRepository.getVideoAttributesLiveData();
    }

    public void refreshVideoAttributes() {
        videoAttributeRepository.getVideoAttributesFromBlobStorage();
    }



}



