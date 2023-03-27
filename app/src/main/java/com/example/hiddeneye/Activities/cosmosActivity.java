package com.example.hiddeneye.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.azure.cosmos.CosmosContainer;
import com.example.hiddeneye.Repository.CosmosDBRepository;
import com.example.hiddeneye.databinding.ActivityCosmosBinding;

public class cosmosActivity extends AppCompatActivity {

    ActivityCosmosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCosmosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CosmosDBRepository cosmosDBRepository = new CosmosDBRepository();
        CosmosContainer container = cosmosDBRepository.getContainer();

        cosmosDBRepository.close();
    }
}