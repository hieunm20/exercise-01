package com.educa.vn.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by Admin on 7/2/2021.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.educa.vn.repository.es")
@ComponentScan(basePackages = "com.educa.vn.service.es")
public class ElasticSearchConfiguration {
  
  @Value("${elasticsearch.host-and-port}")
  private String hostAndPort;
  
  @Bean
  public RestHighLevelClient client() {
    ClientConfiguration clientConfiguration = ClientConfiguration.builder()
        .connectedTo(hostAndPort)
        .build();
    
    return RestClients.create(clientConfiguration).rest();
  }
  
  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchRestTemplate(client());
  }
}
