package com.educa.vn.config;

import com.educa.vn.repository.es.EvenRepositoryEs;
import com.educa.vn.service.es.EvenService;
import com.educa.vn.service.es.EvenServiceImpl;
import com.educa.vn.service.rabbitmq.QueueService;
import com.educa.vn.service.rabbitmq.QueueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 7/2/2021.
 */

@Slf4j
@Configuration
public class ModuleConfiguration {
  
  @Autowired
  private EvenRepositoryEs evenRepositoryEs;
  
  @Autowired
  private RabbitTemplate rabbitTemplate;
  
  @Bean
  @ConditionalOnMissingBean
  public EvenService evenService() {
    return new EvenServiceImpl(evenRepositoryEs);
  }
  
  @Bean
  @ConditionalOnMissingBean
  public QueueService queueService() {
    return new QueueServiceImpl(rabbitTemplate);
  }
  
  
}
