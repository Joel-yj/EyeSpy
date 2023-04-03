package com.example.hiddeneye.Models;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiddeneye.Repository.VideoAttributeRepository;
import com.microsoft.azure.storage.StorageException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

public class VideoAttributeViewModel extends ViewModel {

    private VideoAttributeRepository mRepository;
    private final MutableLiveData<List<VideoAttribute>> mVideoAttributes = new MutableLiveData<>();

    public void init(Context context) {
        if (mRepository == null) {
            try {
                mRepository = new VideoAttributeRepository(context);
                mVideoAttributes.postValue(mRepository.getAllVideoAttributes());
            } catch (URISyntaxException | InvalidKeyException | StorageException | IOException e) {
                Log.e("repo error", e.getMessage());
            }
        }
    }
    public LiveData<List<VideoAttribute>> getVideoAttributes(){
        return mVideoAttributes;
    }

}



