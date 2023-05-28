package com.charles.transformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan("com.charles.transformer.domain")
@EnableJpaRepositories("com.charles.transformer.repository")
public class TransformerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TransformerApplication.class, args);
  }

}
