package com.example.hiddeneye.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hiddeneye.databinding.ActivityBlobBinding;

public class BlobActivity extends AppCompatActivity {

    ActivityBlobBinding binding;
    String s = "DefaultEndpointsProtocol=https;AccountName=testjoel1;AccountKey=dgJefDxywGAy/88I7I2HCOAl4e9Z9dDfjUOtHmtUM8mhUhsosIU5Esbtwt57K245xSOLcbOKIo02+AStzKGhAg==;EndpointSuffix=core.windows.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlobBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





    }
}