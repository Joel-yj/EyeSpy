package com.example.hiddeneye.Repository;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

public class VideoAttributeRepository {

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" + "AccountName=testjoel1;" + "AccountKey=dgJefDxywGAy/88I7I2HCOAl4e9Z9dDfjUOtHmtUM8mhUhsosIU5Esbtwt57K245xSOLcbOKIo02+AStzKGhAg==";

    public static volatile VideoAttributeRepository INSTANCE = null;

    public static VideoAttributeRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (VideoAttributeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VideoAttributeRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void loadData(List<VideoAttribute> list) {

        CloudStorageAccount account;
        try {
            account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient blobClient = account.createCloudBlobClient();

            // Accessing container named "test"
            CloudBlobContainer container = blobClient.getContainerReference("test");

            // Accessing all the json blobs in the container
            for (ListBlobItem blobItem : container.listBlobs()){
                if (blobItem instanceof CloudBlockBlob){
                    CloudBlockBlob blob = (CloudBlockBlob) blobItem;
                    if (blob.getName().endsWith(".json")){
                        InputStream inputStream = blob.openInputStream();
                        Gson gson = new Gson();
                        Reader reader = new InputStreamReader(inputStream);
                        Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
                        ArrayList<VideoAttribute> videoAttributeList = gson.fromJson(reader,listType);
                        list.addAll(videoAttributeList);
                    }
                }
            }


        } catch (URISyntaxException | InvalidKeyException | StorageException e) {
            throw new RuntimeException(e);
        }

    }


}
