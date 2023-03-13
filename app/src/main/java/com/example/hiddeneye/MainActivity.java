package com.example.hiddeneye;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.adapters.ItemAdapter;
import com.example.hiddeneye.models.VideoAttribute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private TableLayout tableLayout;
    private List<VideoAttribute> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tableLayout = findViewById(R.id.table_layout);

        data = toJSON();

        adapter = new ItemAdapter(data);
        recyclerView.setAdapter(adapter);

// Populate TableLayout headers
        TableRow headerRow = new TableRow(this);
        for (int i = 1; i <= 12; i++) {
            TextView header = new TextView(this);
            header.setText("Column " + i);
            header.setPadding(10, 10, 10, 10);
            headerRow.addView(header);
        }
        tableLayout.addView(headerRow);

        // Populate TableLayout with data
        for (VideoAttribute model : data) {
            TableRow tableRow = new TableRow(this);
            for (int i = 1; i <= 12; i++) {
                TextView cell = new TextView(this);
                cell.setText(model.getCellValue(i));
                cell.setPadding(10, 10, 10, 10);
                tableRow.addView(cell);
            }
            tableLayout.addView(tableRow);


        }
    }

    private List<VideoAttribute> toJSON(){

        List<VideoAttribute> data = new ArrayList<>();

// Read the JSON file into a string
        String jsonString = "/Users/joel/Downloads/HiddenEye/app/sampledata/data10.json"; // Replace with actual file reading code

        try {
            // Create a JSON array from the string
            JSONArray jsonArray = new JSONArray(jsonString);

            // Loop through each JSON object in the array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extract the data fields from the JSON object
                String field1 = jsonObject.getString("video_path");
                int field2 = jsonObject.getInt("age");
                String field3 = jsonObject.getString("carrying_backpack");
                String field4 = jsonObject.getString("carrying_handbag");
                String field5 = jsonObject.getString("lower_body_clothing");
                String field6 = jsonObject.getString("length_of_lower_body_clothing");
                String field7 = jsonObject.getString("sleeve_length");
                String field8 = jsonObject.getString("hair_length");
                String field9 = jsonObject.getString("wearing_hat");
                String field10 = jsonObject.getString("gender");
                String field11 = jsonObject.getString("color_upper_body_clothing");
                String field12 = jsonObject.getString("color_lower_body_clothing");

                // Create a new DataModel object with the extracted data fields
                VideoAttribute dataModel = new VideoAttribute(field1, field2, field3,field4,field5,field6,field7,field8,field9,field10,field11,field12);

                // Add the DataModel object to the list
                data.add(dataModel);


            }
        } catch (JSONException e) {
            // Handle JSON parsing error
            e.printStackTrace();
        }

        return data;
    }

}
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