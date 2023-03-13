package com.example.hiddeneye;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.adapters.VideoAttributeAdapter;
import com.example.hiddeneye.models.VideoAttribute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private VideoAttributeAdapter adapter;
    private RecyclerView recyclerView;
    private List<VideoAttribute> videoAttributeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Loading Json data
        String jsonData = loadJsonData();
        Gson gson = new Gson();
        Type videoAttributeType = new TypeToken<List<VideoAttribute>>(){}.getType();
        videoAttributeList = gson.fromJson(jsonData,videoAttributeType);
        System.out.println(jsonData);

        // referencing recycler_view
        recyclerView = findViewById(R.id.recycler_view);
        //create and set adapter
//        adapter = new VideoAttributeAdapter(videoAttributeList);
//        recyclerView.setAdapter(adapter);
        //set layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

    }

    private String loadJsonData() {

        // Load Json Data from file using AssetManager
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("data10.json");
            Scanner scanner = new Scanner(inputStream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
            return builder.toString();
        } catch (IOException e) {
            Log.e("MainActivity", "Error loading json data", e);
            return null;
        }
    }
}


//// Read the JSON file into a string
//        String jsonString = "/Users/joel/Downloads/HiddenEye/app/sampledata/data10.json"; // Replace with actual file reading code
//
//        try {
//            // Create a JSON array from the string
//            JSONArray jsonArray = new JSONArray(jsonString);
//
//            // Loop through each JSON object in the array
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                // Extract the data fields from the JSON object
//                String field1 = jsonObject.getString("video_path");
//                int field2 = jsonObject.getInt("age");
//                String field3 = jsonObject.getString("carrying_backpack");
//                String field4 = jsonObject.getString("carrying_handbag");
//                String field5 = jsonObject.getString("lower_body_clothing");
//                String field6 = jsonObject.getString("length_of_lower_body_clothing");
//                String field7 = jsonObject.getString("sleeve_length");
//                String field8 = jsonObject.getString("hair_length");
//                String field9 = jsonObject.getString("wearing_hat");
//                String field10 = jsonObject.getString("gender");
//                String field11 = jsonObject.getString("color_upper_body_clothing");
//                String field12 = jsonObject.getString("color_lower_body_clothing");
//
//                try {
//                    Reader reader = new FileReader("/Users/joel/Downloads/HiddenEye/app/sampledata/data10.json");
//                    Gson gson = new Gson();
//                    VideoAttribute[] myarray = gson.fromJson(reader,VideoAttribute[].class);
//                    System.out.println(myarray);
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//
//
//
//                // Create a new DataModel object with the extracted data fields
//                VideoAttribute dataModel = new VideoAttribute(field1, field2, field3,field4,field5,field6,field7,field8,field9,field10,field11,field12);
//
//                // Add the DataModel object to the list
//                data.add(dataModel);
//
//
//            }
//        } catch (JSONException e) {
//            // Handle JSON parsing error
//            e.printStackTrace();
//        }
//
//        return data;
//    }

//TODO Data base stuff that didnt work

//    final String HOST = "AccountEndpoint=https://test-joel.documents.azure.com:443/;AccountKey=FkNeeYURaeRPIS9P5LB7iELPYZNBF8a3gQ10TsTDldXdkCCP3Yv3ACKT0LcdfYKHzbM255zLOJMbACDbRJdaVQ==;";
//        final String MASTER_KEY = "FkNeeYURaeRPIS9P5LB7iELPYZNBF8a3gQ10TsTDldXdkCCP3Yv3ACKT0LcdfYKHzbM255zLOJMbACDbRJdaVQ==";
//
//        CosmosClient client = new CosmosClientBuilder()
//                .endpoint(HOST)
//                .key(MASTER_KEY)
//                .consistencyLevel(ConsistencyLevel.EVENTUAL)
//                .buildClient();
//
//        CosmosContainer container = client.getDatabase("Test").
//                getContainer("test1");
//
//        String query = "SELECT * FROM c";
//
//        CosmosPagedIterable<Document> documents = container.queryItems(query,new CosmosQueryRequestOptions(), Document.class);
//
//        for (Document document : documents){
//            System.out.println(document.toJson());
//        }