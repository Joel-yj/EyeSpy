package com.example.hiddeneye.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hiddeneye.Activities.Fragments.ExploreFragment;
import com.example.hiddeneye.Activities.Fragments.LiveStreamFragment;
import com.example.hiddeneye.Activities.Fragments.HomeFragment;
import com.example.hiddeneye.R;
import com.example.hiddeneye.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {


    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.explore:
                    replaceFragment(new ExploreFragment());
                    break;
                case R.id.liveStream:
                    replaceFragment(new LiveStreamFragment());
                    break;
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
            }

            return true;
        });



    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}