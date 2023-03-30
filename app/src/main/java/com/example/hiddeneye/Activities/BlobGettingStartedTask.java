package com.example.hiddeneye.Activities;

import android.os.AsyncTask;
import android.widget.TextView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

            CloudStorageAccount account = CloudStorageAccount
                    .parse(BlobActivity.storageConnectionString);
            CloudBlobClient blobClient = account.createCloudBlobClient();
            CloudBlobContainer container = blobClient.getContainerReference("test");

            // Creating blobs
            CloudBlockBlob blob = container.getBlockBlobReference("test2.json");
            blob.uploadText("test hello");

            //iterating through blobs
            for (ListBlobItem blobItem : container.listBlobs()){
                if (blobItem instanceof CloudBlob){
                    CloudBlob blobby = (CloudBlob) blobItem;
                    blobby.download(Files.newOutputStream(Paths.get("assets" + blobby.getName())));
                }
            }

        } catch (URISyntaxException | InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (StorageException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//            // Setup the cloud storage account.
//            CloudStorageAccount account = CloudStorageAccount
//                    .parse(BlobActivity.storageConnectionString);
//
//            // Create a blob service client
//            CloudBlobClient blobClient = account.createCloudBlobClient();
//
//            // Get a reference to a container
//            // The container name must be lower case
//            // Append a random UUID to the end of the container name so that
//            // this sample can be run more than once in quick succession.
//            CloudBlobContainer container = blobClient.getContainerReference("test");
//
////            // Create the container if it does not exist
////            container.createIfNotExists();
////
////            // Make the container public
////            // Create a permissions object
////            BlobContainerPermissions containerPermissions = new BlobContainerPermissions();
////
////            // Include public access in the permissions object
////            containerPermissions
////                    .setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
////
////            // Set the permissions on the container
////            container.uploadPermissions(containerPermissions);
//
//            // Upload 3 blobs
//            // Get a reference to a blob in the container
//            CloudBlockBlob blob1 = container
//                    .getBlockBlobReference("blobbasicsblob1");
//
//            // Upload text to the blob
//            blob1.uploadText("Hello, World1");
//
//            // Get a reference to a blob in the container
//            CloudBlockBlob blob2 = container
//                    .getBlockBlobReference("blobbasicsblob2");
//
//            // Upload text to the blob
//            blob2.uploadText("Hello, World2");
//
//            // Get a reference to a blob in the container
//            CloudBlockBlob blob3 = container
//                    .getBlockBlobReference("blobbasicsblob3");
//
//            // Upload text to the blob
//            blob3.uploadText("Hello, World3");
//
//            // Download the blob
//            // For each item in the container
//            for (ListBlobItem blobItem : container.listBlobs()) {
//                // If the item is a blob, not a virtual directory
//                if (blobItem instanceof CloudBlockBlob) {
//                    // Download the text
//                    CloudBlockBlob retrievedBlob = (CloudBlockBlob) blobItem;
//                    act.outputText(view, retrievedBlob.downloadText());
//                }
//            }
//
//            // List the blobs in a container, loop over them and
//            // output the URI of each of them
//            for (ListBlobItem blobItem : container.listBlobs()) {
//                act.outputText(view, blobItem.getUri().toString());
//            }
//
//            // Delete the blobs
//            blob1.deleteIfExists();
//            blob2.deleteIfExists();
//            blob3.deleteIfExists();
//
//            // Delete the container
//            container.deleteIfExists();
//        } catch (Throwable t) {
//            act.printException(t);
//        }

        act.printSampleCompleteInfo("BlobBasics");

        return null;
    }
}
