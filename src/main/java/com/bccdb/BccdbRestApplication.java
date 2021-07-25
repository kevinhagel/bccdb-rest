package com.bccdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BccdbRestApplication {


  public static void main(String[] args) {
    SpringApplication.run(BccdbRestApplication.class, args);
  }

}
