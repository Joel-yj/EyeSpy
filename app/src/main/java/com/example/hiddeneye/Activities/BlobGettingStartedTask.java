package com.example.hiddeneye.Activities;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;

public class BlobGettingStartedTask extends AsyncTask<String, Void, Void> {

    private TextView view;
    private BlobActivity act;

    public BlobGettingStartedTask(BlobActivity act, TextView view) {
        this.view = view;
        this.act = act;
    }

    @Override
    protected Void doInBackground(String... arg0) {

        act.printSampleStartInfo("BlobBasics");

        try {
            // Setup the cloud storage account.
            CloudStorageAccount account = CloudStorageAccount
                    .parse(BlobActivity.storageConnectionString);

            // Create a blob service client
            CloudBlobClient blobClient = account.createCloudBlobClient();

            // Creating blobs
            CloudBlockBlob blob = container.getBlockBlobReference("android_test.json");
//            blob.uploadText("test hello");


            // converting json file from blob into videoattribute model object
            InputStream inputStream = blob.openInputStream();
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(inputStream);
            Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
            ArrayList<VideoAttribute> videoAttributeList = gson.fromJson(reader,listType);

            // videoattribute objects
            for (VideoAttribute item : videoAttributeList){
                System.out.println(item.getVideoPath());
            }

            // binds blob contents to textview
//            act.outputText(view, blob.downloadText());
//            act.outputText(view, videoAttribute.getVideoPath());


//            //iterating through blobs
//            for (ListBlobItem blobItem : container.listBlobs()){
//                if (blobItem instanceof CloudBlob){
//                    CloudBlob blobby = (CloudBlob) blobItem;
//                }
//            }

        } catch (URISyntaxException | InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (StorageException e) {
            throw new RuntimeException(e);
        }

        act.printSampleCompleteInfo("BlobBasics");

        return null;
    }
}
