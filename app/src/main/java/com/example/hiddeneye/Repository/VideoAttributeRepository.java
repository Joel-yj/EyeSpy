package com.example.hiddeneye.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VideoAttributeRepository {

    private DatabaseReference database = FirebaseDatabase.getInstance().getReference("Users");

    public static volatile VideoAttributeRepository INSTANCE = null;

    public static VideoAttributeRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (VideoAttributeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VideoAttributeRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void loadData(MutableLiveData<List<VideoAttribute>> list) {

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<VideoAttribute> _list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    VideoAttribute videoAttribute = dataSnapshot.getValue(VideoAttribute.class);
                    _list.add(videoAttribute);
                }
                list.postValue(_list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
