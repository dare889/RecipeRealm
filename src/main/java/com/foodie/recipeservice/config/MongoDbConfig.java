package com.foodie.recipeservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "recipe_db";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/recipe_db"))
                .build());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}