package com.example.hiddeneye.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobProperties;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

public class VideoAttributeRepository {

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" + "AccountName=testjoel1;" + "AccountKey=dgJefDxywGAy/88I7I2HCOAl4e9Z9dDfjUOtHmtUM8mhUhsosIU5Esbtwt57K245xSOLcbOKIo02+AStzKGhAg==";
    private final CloudBlobClient mBlobClient;
    private final CloudBlobContainer mBlobContainer;

    public VideoAttributeRepository(Application application){
        try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            mBlobClient = account.createCloudBlobClient();
            mBlobContainer = mBlobClient.getContainerReference("test");
        } catch (URISyntaxException | InvalidKeyException | StorageException e) {
            throw new RuntimeException(e);
        }

    }

    public LiveData<List<VideoAttribute>> getVideoAttributes() {
        MutableLiveData<List<VideoAttribute>> data = new MutableLiveData<>();

        try {
            List<VideoAttribute> videoAttributes = new ArrayList<>();

            for (ListBlobItem blobItem : mBlobContainer.listBlobs()) {
                if (blobItem instanceof CloudBlockBlob) {
                    CloudBlockBlob blob = (CloudBlockBlob) blobItem;

                    if (blob.getName().endsWith(".json")) {
                        BlobProperties properties = blob.getProperties();

                        VideoAttribute videoAttribute = new Gson().fromJson(
                                new BufferedReader(new InputStreamReader(blob.openInputStream())).toString(),
                                VideoAttribute.class);

                        videoAttributes.add(videoAttribute);
                    }
                }
            }

            data.setValue(videoAttributes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


}