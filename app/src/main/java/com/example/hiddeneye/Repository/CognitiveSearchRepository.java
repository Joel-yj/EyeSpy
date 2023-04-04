package com.example.hiddeneye.Repository;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.search.documents.SearchClient;
import com.azure.search.documents.SearchClientBuilder;
import com.azure.search.documents.util.SearchPagedIterable;
import com.example.hiddeneye.Models.VideoAttribute;

public class CognitiveSearchRepository {

    //TODO protect apikey (same as storageblob)
    String endpoint = "https://test-joel.search.windows.net";
    String apikey = "ApZGjq5ub4YYtJhr65j8lfWIpMva8Qes7pbCHDT51nAzSeCIPW0x";
    String indexName = "azureblob-test-index";


    public CognitiveSearchRepository() {
        SearchClient searchClient = new SearchClientBuilder()
                .endpoint(endpoint)
                .credential(new AzureKeyCredential(apikey))
                .indexName(indexName)
                .buildClient();
    }

    public static void WriteSearchResults(SearchPagedIterable searchResults){
        searchResults.iterator().forEachRemaining(
                result -> {
                    VideoAttribute item = result.getDocument(VideoAttribute.class);
                    System.out.println(item);
                }
        );
    }
}
//    //Builds the indexer
//    SearchIndexClient searchIndexClient = new SearchIndexClientBuilder()
//            .endpoint(endpoint)
//            .credential(new AzureKeyCredential(apikey))
//            .buildClient();


