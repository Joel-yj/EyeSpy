package com.example.hiddeneye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hiddeneye.Activities.HomeActivity;
import com.example.hiddeneye.databinding.ActivityMainBinding;


/**
 * The main activity of the HiddenEye app.
 * This activity serves as the entry point and contains the main user interface.
 * Can be deleted when unnecessary
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Set click listener for the "Populate" button
        binding.recyclerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the HomeActivity
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });


    }




}