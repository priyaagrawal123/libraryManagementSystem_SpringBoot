// package com.example.demo.config;

// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
// import org.springframework.data.mongodb.core.AbstractMongoClientConfiguration;

// @Configuration
// @EnableMongoRepositories(basePackages = "com.example.demo.repository")
// public class MongoConfig extends AbstractMongoClientConfiguration {

//     @Override
//     protected String getDatabaseName() {
//         return "your_database_name";  // Replace with your actual database name
//     }

//     @Override
//     public MongoClient mongoClient() {
//         return MongoClients.create("mongodb://localhost:27017");  // MongoDB URI
//     }

//     @Bean
//     public MongoTemplate mongoTemplate(MongoClient mongoClient) {
//         return new MongoTemplate(mongoClient, getDatabaseName());
//     }
// }
