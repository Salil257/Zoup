package com.zoup.orderapi.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Collections;

@Configuration
public class MongoConfig {

    @Bean
    public String databaseName() {
        return "dev";
    }

    @Bean
    public MongoClient getMongoClient() {
//        MongoCredential credential = MongoCredential.createCredential("admin1", "admin", String.format("cfilorux17SYZYGY").toCharArray());
        return MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress("127.0.0.1", 27017))))
                .build());
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(getMongoClient(),databaseName());
    }
}
