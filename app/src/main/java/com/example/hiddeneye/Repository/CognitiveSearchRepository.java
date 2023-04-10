//package com.example.hiddeneye.Repository;
//
//import androidx.lifecycle.MutableLiveData;
//
//import com.azure.core.credential.AzureKeyCredential;
//import com.azure.core.util.Context;
//import com.azure.search.documents.SearchClient;
//import com.azure.search.documents.SearchClientBuilder;
//import com.azure.search.documents.models.SearchOptions;
//import com.azure.search.documents.models.SearchResult;
//import com.azure.search.documents.util.SearchPagedIterable;
//import com.example.hiddeneye.Models.VideoAttribute;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
//public class CognitiveSearchRepository {
//
//    //TODO protect apikey (same as storageblob)
//    String endpoint = "https://test-joel.search.windows.net";
//    AzureKeyCredential adminKey = new AzureKeyCredential("ApZGjq5ub4YYtJhr65j8lfWIpMva8Qes7pbCHDT51nAzSeCIPW0x");
//    String indexName = "azureblob-test-index";
//    SearchClient searchClient;
//    private MutableLiveData<List<VideoAttribute>> videoAttributesLiveData;
//
//
//    public CognitiveSearchRepository() {
//        System.out.println("Constructor initialised");
//        videoAttributesLiveData = new MutableLiveData<>();
//        System.out.println("Constructor completed");
//    }
//
//    public void searchVideos(String searchQuery) {
//        System.out.println("search method block");
//        Executor serialExecutor = Executors.newSingleThreadExecutor();
//
//        serialExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run method block");
//                try {
//                    System.out.println("client builder block");
//                    System.out.println(adminKey);
//                    searchClient = new SearchClientBuilder()
//                            .credential(adminKey)
//                            .endpoint(endpoint)
//                            .indexName(indexName)
//                            .buildClient();
//
//
//                    System.out.println("search options block");
//                    SearchOptions options = new SearchOptions();
//                    options.setIncludeTotalCount(true);
//                    options.setFilter("");
//                    options.setOrderBy("");
//                    options.setSelect("videoPath", "age");
//
//                    System.out.println("search results block");
//                    SearchPagedIterable results = searchClient.search(searchQuery, options, Context.NONE);
//
//                    System.out.println("search items block");
//                    List<VideoAttribute> items = new ArrayList<>();
//                    for (SearchResult result : results) {
//                        VideoAttribute item = result.getDocument(VideoAttribute.class);
//                        items.add(item);
//                    }
//                    System.out.println(items.get(1));
//
//                    videoAttributesLiveData.postValue(items);
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }
//}
//
////    //Builds the indexer
////    SearchIndexClient searchIndexClient = new SearchIndexClientBuilder()
////            .endpoint(endpoint)
////            .credential(new AzureKeyCredential(apikey))
////            .buildClient();
//
//
////        System.out.println("******* Query here *******");
////                SearchOptions options = new SearchOptions();
////                options.setIncludeTotalCount(true);
////                options.setFilter("");
////                options.setOrderBy("");
////                options.setSelect("videoPath", "age");
//
//
////    public static void WriteSearchResults(SearchPagedIterable searchResults) {
////        searchResults.iterator().forEachRemaining(
////                result -> {
////                    VideoAttribute item = result.getDocument(VideoAttribute.class);
////                    System.out.println(item);
////                }
////        );
////    }
//
