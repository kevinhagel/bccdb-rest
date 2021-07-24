package com.bccdb.rest.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * MongoReactiveApplication
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@EnableReactiveMongoRepositories
@Profile("test")
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return "bccdb-reactive";
  }
}
