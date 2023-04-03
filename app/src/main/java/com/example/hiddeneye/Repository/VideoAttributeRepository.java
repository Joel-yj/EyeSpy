package com.example.hiddeneye.Repository;

import android.content.Context;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

public class VideoAttributeRepository {

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" +
            "AccountName=testjoel1;" +
            "AccountKey=dgJefDxywGAy/88I7I2HCOAl4e9Z9dDfjUOtHmtUM8mhUhsosIU5Esbtwt57K245xSOLcbOKIo02+AStzKGhAg==";
    private final CloudBlobClient mBlobClient;
//    private final CloudBlobContainer mBlobContainer;

    public VideoAttributeRepository(Context context) throws URISyntaxException, InvalidKeyException {
        CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
        mBlobClient = account.createCloudBlobClient();
    }

    public List<VideoAttribute> getAllVideoAttributes() throws StorageException, IOException, URISyntaxException {
        CloudBlobContainer container = mBlobClient.getContainerReference("test");
        List<VideoAttribute> videoAttributes = new ArrayList<>();

        for (ListBlobItem blobItem : container.listBlobs()){
            if (blobItem instanceof CloudBlockBlob){
                CloudBlockBlob blob = (CloudBlockBlob) blobItem;
                if (blob.getName().endsWith(".json")){
                    InputStream inputStream = blob.openInputStream();
                    Gson gson = new Gson();
                    Reader reader = new InputStreamReader(inputStream);
                    Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
                    videoAttributes = gson.fromJson(reader,listType);
                }
            }
        }
        return videoAttributes;
    }



}