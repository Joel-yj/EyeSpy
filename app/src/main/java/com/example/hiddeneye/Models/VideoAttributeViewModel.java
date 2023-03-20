package com.example.hiddeneye.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hiddeneye.Repository.VideoAttributeRepository;

import java.util.List;

public class VideoAttributeViewModel extends ViewModel {

    private VideoAttributeRepository repository;
    private MutableLiveData<List<VideoAttribute>> _allVideoAttributes = new MutableLiveData<>();
    public LiveData<List<VideoAttribute>> allVideoAttributes = _allVideoAttributes;

    public VideoAttributeViewModel(){
        repository = VideoAttributeRepository.getInstance();
        repository.loadData(_allVideoAttributes);
    }

}
