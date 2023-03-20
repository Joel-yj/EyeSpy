package com.example.hiddeneye;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.example.hiddeneye.adapters.VideoDataAdapter;
import com.example.hiddeneye.models.VideoAttribute;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
//    DatabaseReference database;

    private final String DATABASE_ID = "Test";
    private final String CONTAINER_ID ="test1";
    VideoDataAdapter myAdapter;
    ArrayList<VideoAttribute> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.userList);

        // TODO nid to switch to microsoft azure database
//        database = FirebaseDatabase.getInstance().getReference("Users");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        //TODO use the event listener for cosmosdb

        CosmosClient client = new CosmosClientBuilder()
                .endpoint("https://test-joel.documents.azure.com:443/")
                .key("UvSoY0qjoS9Hqosdz5ndT9hPJAhHKJcXyf2fvDoWVOH8fU912yve3xdquZF0CywSXBoxUGZEN91LACDbsmGDWA==")
                .buildClient();
        String query = "SELECT * FROM c";
        CosmosPagedIterable<VideoAttribute> results = client.getDatabase(DATABASE_ID).getContainer(CONTAINER_ID).queryItems(query,new CosmosQueryRequestOptions(),VideoAttribute.class);

        for(VideoAttribute videoAttribute : results){
            list.add(videoAttribute);
            myAdapter = new VideoDataAdapter(recyclerView.getContext(),list);
            recyclerView.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }



//
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

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item,menu);

        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Type a search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}