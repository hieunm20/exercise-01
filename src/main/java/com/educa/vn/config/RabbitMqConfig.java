package com.educa.vn.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hieunm on 3/7/2021.
 */

@Configuration
public class RabbitMqConfig {
  
  @Value("${spring.rabbitmq.concurrent-consumers}")
  private Integer concurrentConsumers;
  
  @Value("${spring.rabbitmq.max-concurrent-consumers}")
  private Integer maxConcurrentConsumers;
  
  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
  
  @Bean
  public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
      SimpleRabbitListenerContainerFactoryConfigurer configurer) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConcurrentConsumers(concurrentConsumers);
    factory.setMaxConcurrentConsumers(maxConcurrentConsumers);
    factory.setMessageConverter(jsonMessageConverter());
    configurer.configure(factory, connectionFactory);
    return factory;
  }
}
