package com.example.hiddeneye.Activities;

import android.os.AsyncTask;
import android.widget.TextView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

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
            System.out.println("1");
            CloudStorageAccount account = CloudStorageAccount
                    .parse(BlobActivity.storageConnectionString);
            System.out.println("2");

            // Create a blob service client
            CloudBlobClient blobClient = account.createCloudBlobClient();
            System.out.println("3");

            CloudBlobContainer container = blobClient.getContainerReference("test");
            System.out.println("4");

            // Creating blobs
            CloudBlockBlob blob = container.getBlockBlobReference("test3.json");
            System.out.println("5");
            blob.uploadText("test hello");


//            // converting json file from blob into videoattribute model object
//            InputStream inputStream = blob.openInputStream();
//            Gson gson = new Gson();
//            Reader reader = new InputStreamReader(inputStream);
//            Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
//            ArrayList<VideoAttribute> videoAttributeList = gson.fromJson(reader,listType);
////
////            // videoattribute objects
//            for (VideoAttribute item : videoAttributeList){
//                System.out.println(item.getVideoPath());
//            }

            // binds blob contents to textview
//            act.outputText(view, blob.downloadText());
//            act.outputText(view, videoAttribute.getVideoPath());


//            //iterating through blobs
//            for (ListBlobItem blobItem : container.listBlobs()){
//                if (blobItem instanceof CloudBlob){
//                    CloudBlob blobby = (CloudBlob) blobItem;
//                }
//            }

        } catch (URISyntaxException | InvalidKeyException | IOException e) {
            System.out.println("6");
            throw new RuntimeException(e);
        } catch (StorageException e) {
            System.out.println("7");
            throw new RuntimeException(e);
        }

        act.printSampleCompleteInfo("BlobBasics");

        return null;
    }
}
