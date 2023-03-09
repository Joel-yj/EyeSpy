package com.example.hiddeneye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.example.hiddeneye.adapters.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.item_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);
        final String HOST = "AccountEndpoint=https://test-joel.documents.azure.com:443/;AccountKey=FkNeeYURaeRPIS9P5LB7iELPYZNBF8a3gQ10TsTDldXdkCCP3Yv3ACKT0LcdfYKHzbM255zLOJMbACDbRJdaVQ==;";
        final String MASTER_KEY = "FkNeeYURaeRPIS9P5LB7iELPYZNBF8a3gQ10TsTDldXdkCCP3Yv3ACKT0LcdfYKHzbM255zLOJMbACDbRJdaVQ==";

        CosmosClient client = new CosmosClientBuilder()
                .endpoint(HOST)
                .key(MASTER_KEY)
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();

        CosmosContainer container = client.getDatabase("Test").
                getContainer("test1");

//        String query = "SELECT * FROM c";
//
//        CosmosPagedIterable<Document> documents = container.queryItems(query,new CosmosQueryRequestOptions(), Document.class);
//
//        for (Document document : documents){
//            System.out.println(document.toJson());
//        }



    }
}