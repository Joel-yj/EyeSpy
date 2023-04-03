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

public class VideoAttributeRepository {
    private MutableLiveData<List<VideoAttribute>> videoAttributesLiveData;

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" +
            "AccountName=testjoel1;" +
            "AccountKey=w7mc7NKblY8iAj1tFljAJdmhx9BEXsw4A10l9iN92CFO/yuhCJFg3HwhuZ3G1EtoXBHFUHNcvGO/+ASt506U9g==";

    public VideoAttributeRepository(){
        videoAttributesLiveData = new MutableLiveData<>();
    }

    public void getVideoAttributesFromBlobStorage(){
        Executor serialExecutor = Executors.newSingleThreadExecutor();

        serialExecutor.execute(new Runnable() {
            @Override
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
                    // able to get model object
                    System.out.println(videoAttributes.get(1).getVideoPath());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    public LiveData<List<VideoAttribute>> getVideoAttributesLiveData(){
        return videoAttributesLiveData;
    }

}
//    for (ListBlobItem blobItem : container.listBlobs()){
//                    if (blobItem instanceof CloudBlockBlob){
//                        CloudBlockBlob jsonBlob = (CloudBlockBlob) blobItem;
//                        String jsonContent = jsonBlob.downloadText();
//                        Gson gson = new Gson();
//                        VideoAttribute videoItem = gson.fromJson(jsonContent,VideoAttribute.class);
//                        System.out.println(videoItem.getVideoPath());
//                        videoAttributeList.add(videoItem);
//
//                    }
//                }


