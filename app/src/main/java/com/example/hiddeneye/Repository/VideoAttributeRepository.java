package com.example.hiddeneye.Repository;

import com.example.hiddeneye.Models.VideoAttribute;
import com.google.gson.Gson;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoAttributeRepository {

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;" +
            "AccountName=testjoel1;" +
            "AccountKey=w7mc7NKblY8iAj1tFljAJdmhx9BEXsw4A10l9iN92CFO/yuhCJFg3HwhuZ3G1EtoXBHFUHNcvGO/+ASt506U9g==";
    private final CloudBlobClient mBlobClient;
    private ExecutorService executorService;

    public VideoAttributeRepository() throws URISyntaxException, InvalidKeyException {
        CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
        mBlobClient = account.createCloudBlobClient();
        executorService = Executors.newFixedThreadPool(5);
    }

    public void getVideoAttributes(Callback callback){
        executorService.execute(()->{
            try{
                CloudBlobContainer container = mBlobClient.getContainerReference("test");
                List<VideoAttribute> videoAttributeList = new ArrayList<>();
                CloudBlockBlob blob = container.getBlockBlobReference("android_test.json");
                String jsonContent = blob.downloadText();
                Gson gson = new Gson();
                System.out.print(gson.fromJson(jsonContent,VideoAttribute.class).getVideoPath());

//                for (ListBlobItem blobItem : container.listBlobs()){
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
                callback.onVideoAttributesLoaded(videoAttributeList);
            }catch (Exception e){
                callback.onError(e);
            }
        });
    }

    public interface Callback {
        void onVideoAttributesLoaded(List<VideoAttribute> videoAttributes);
        void onError(Exception e);
    }

//    public List<VideoAttribute> getAllVideoAttributes() throws StorageException, IOException, URISyntaxException {
//        CloudBlobContainer container = mBlobClient.getContainerReference("test");
//        List<VideoAttribute> videoAttributes = new ArrayList<>();
//
//        for (ListBlobItem blobItem : container.listBlobs()){
//            if (blobItem instanceof CloudBlockBlob){
//                CloudBlockBlob blob = (CloudBlockBlob) blobItem;
//                if (blob.getName().endsWith(".json")){
//                    InputStream inputStream = blob.openInputStream();
//                    Gson gson = new Gson();
//                    Reader reader = new InputStreamReader(inputStream);
//                    Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
//                    videoAttributes = gson.fromJson(reader,listType);
//                }
//            }
//        }
//        return videoAttributes;
//    }



}