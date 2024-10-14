    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {            
        return new CosmosClientBuilder()
            .endpoint("<azure-cosmos-db-nosql-endpoint>")
            .key("<azure-cosmos-db-nosql-key>");
    }