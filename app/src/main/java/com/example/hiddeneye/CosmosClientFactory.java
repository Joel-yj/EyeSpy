package com.example.hiddeneye;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;

public class CosmosClientFactory {

    private static final String HOST = "https://test-joel.documents.azure.com:443/";
    private static final String MASTER_KEY = "FkNeeYURaeRPIS9P5LB7iELPYZNBF8a3gQ10TsTDldXdkCCP3Yv3ACKT0LcdfYKHzbM255zLOJMbACDbRJdaVQ==";

    private static final CosmosClient cosmosClient = new CosmosClientBuilder()
            .endpoint(HOST)
            .key(MASTER_KEY)
            .consistencyLevel(ConsistencyLevel.EVENTUAL)
            .buildClient();

    public static CosmosClient getCosmosClient() {
        return cosmosClient;
    }
}
