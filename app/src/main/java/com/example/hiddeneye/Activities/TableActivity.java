package com.example.hiddeneye.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Adapters.TableAdapter;
import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    
    RecyclerView recyclerView;
    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" +
            "AccountName=testjoel1;" +
            "AccountKey=w7mc7NKblY8iAj1tFljAJdmhx9BEXsw4A10l9iN92CFO/yuhCJFg3HwhuZ3G1EtoXBHFUHNcvGO/+ASt506U9g==";
    TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        
        recyclerView = findViewById(R.id.recycler_view_table);
        try {
            setRecyclerView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setRecyclerView() throws IOException {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TableAdapter(this,getList());
        recyclerView.setAdapter(adapter);
    
    }

    private List<VideoAttribute> getList() throws IOException {

        List<VideoAttribute> video;
        InputStream inputStream = getAssets().open("android_test.json");
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(inputStream);
        Type listType = new TypeToken<List<VideoAttribute>>(){}.getType();
        video = gson.fromJson(reader,listType);


        return video;
    }
}