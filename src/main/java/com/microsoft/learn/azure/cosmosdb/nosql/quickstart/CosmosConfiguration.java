package com.microsoft.learn.azure.cosmosdb.nosql.quickstart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

// <repository_configuration>
@Configuration
@EnableCosmosRepositories
public class CosmosConfiguration extends AbstractCosmosConfiguration {
// </repository_configuration>

    @Value("#{environment.AZURE_COSMOS_DB_NOSQL_ENDPOINT}")
    private String uri;

    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {            
        return new CosmosClientBuilder()
            .endpoint("<azure-cosmos-db-nosql-endpoint>")
            .key("<azure-cosmos-db-nosql-key>");
    }

    @Override
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
            .enableQueryMetrics(true)
            .build();
    }

    // <get_database>
    @Override
    protected String getDatabaseName() {
        return "cosmicworks";
    }
    // </get_database>
}
