package com.example.hiddeneye.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Repository class for retrieving video attributes from Azure Blob Storage.
 * This class provides methods to fetch video attributes and exposes them as LiveData for observing changes.
 */
public class VideoAttributeRepository {
    private MutableLiveData<List<VideoAttribute>> videoAttributesLiveData;

    //TODO Find a way to protect connectionString - try config.properties file
    private static final String storageConnectionString = "";

    /**
     * Constructs a new instance of VideoAttributeRepository.
     */
    public VideoAttributeRepository(){
        videoAttributesLiveData = new MutableLiveData<>();
    }

    /**
     * Retrieves video attributes from Azure Blob Storage.
     * The video attributes are fetched asynchronously and stored in the LiveData for observation.
     */
    public void getVideoAttributesFromBlobStorage(){
        Executor serialExecutor = Executors.newSingleThreadExecutor();

        serialExecutor.execute(new Runnable() {
            @Override
            //TODO iterate through different CloudBlockBlobs in container
            public void run() {
                try{
                    CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
                    CloudBlobClient mBlobClient = account.createCloudBlobClient();
                    CloudBlobContainer container = mBlobClient.getContainerReference("test");
                    CloudBlockBlob blob = container.getBlockBlobReference("android_test.json");
                    InputStream inputStream = blob.openInputStream();
                    Gson gson = new Gson();
                    Reader reader = new InputStreamReader(inputStream);
                    Type listType = new TypeToken<List<VideoAttribute>>(){}.getType();
                    List<VideoAttribute> videoAttributes = gson.fromJson(reader,listType);
                    videoAttributesLiveData.postValue(videoAttributes);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Returns the LiveData containing the video attributes.
     *
     * @return LiveData object representing the video attributes.
     */
    public LiveData<List<VideoAttribute>> getVideoAttributesLiveData(){
        return videoAttributesLiveData;
    }

}



