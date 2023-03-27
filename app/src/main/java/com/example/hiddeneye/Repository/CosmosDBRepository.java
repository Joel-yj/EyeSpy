package com.example.hiddeneye.Repository;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;

public class CosmosDBRepository {

    private static final String uri = "https://test-joel.documents.azure.com:443/";
    private static final String key = "UvSoY0qjoS9Hqosdz5ndT9hPJAhHKJcXyf2fvDoWVOH8fU912yve3xdquZF0CywSXBoxUGZEN91LACDbsmGDWA==";
    private static final String database = "test";
    private static final String container = "test";

    private CosmosClient client;
    private CosmosDatabase cosmosDatabase;
    private CosmosContainer cosmosContainer;

    public CosmosDBRepository(){
        client = new CosmosClientBuilder().endpoint(uri).key(key).buildClient();

        cosmosDatabase = client.getDatabase(database);
        cosmosContainer = cosmosDatabase.getContainer(container);

    }

    public CosmosContainer getContainer() {
        return cosmosContainer;
    }

    public void close(){
        client.close();
    }


}