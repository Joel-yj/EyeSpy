package com.example.hiddeneye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hiddeneye.adapters.ItemAdapter;
import com.example.hiddeneye.models.VideoAttribute;
import com.example.hiddeneye.Activities.HomeActivity;
import com.example.hiddeneye.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private TableLayout tableLayout;
    private List<VideoAttribute> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });


    }




}
