package com.example.hiddeneye.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hiddeneye.Activities.Fragments.HomeFragment;
import com.example.hiddeneye.Activities.Fragments.LiveStreamFragment;
import com.example.hiddeneye.R;
import com.example.hiddeneye.Activities.Fragments.SettingsFragment;
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
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.liveStream:
                    replaceFragment(new LiveStreamFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }

            return true;
        });



//        recyclerView = binding.userList;
//
//        // TODO nid to switch to microsoft azure database
//        database = FirebaseDatabase.getInstance().getReference("Users");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        list = new ArrayList<>();
//
//        //TODO use the event listener for cosmosdb
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    VideoAttribute videoAttribute = dataSnapshot.getValue(VideoAttribute.class);
//                    list.add(videoAttribute);
//                }
//                //TODO find a way to fix this lag? need a way to pull data from db before building view
//                myAdapter = new VideoDataAdapter(recyclerView.getContext(),list);
//                recyclerView.setAdapter(myAdapter);
//                myAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_item,menu);
//
//        CardView cardView = findViewById(R.id.attributeCard);
//        MenuItem menuItem = menu.findItem(R.id.search_action);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setQueryHint("Type a search");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                myAdapter.getFilter().filter(newText);
//
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//
//
//    }

}