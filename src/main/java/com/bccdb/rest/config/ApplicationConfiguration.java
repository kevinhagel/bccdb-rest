package com.bccdb.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * ApplicationConfiguration
 *
 * @author Kevin Hagel
 * @since 2021-07-24
 */
@Configuration
public class ApplicationConfiguration {


  @Bean
  public ObjectMapper objectMapper() {
    return Jackson2ObjectMapperBuilder.json().build();
  }

  @Bean
  public MongoClientFactoryBean mongo() {
    MongoClientFactoryBean mongo = new MongoClientFactoryBean();
    mongo.setHost("localhost");
    return mongo;
  }

}
