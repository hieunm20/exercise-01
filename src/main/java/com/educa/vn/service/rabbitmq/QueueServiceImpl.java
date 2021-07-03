package com.educa.vn.service.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 7/2/2021.
 */

@Slf4j
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {
  
  private final RabbitTemplate rabbitTemplate;
  
  @Override
  public void push(Object message, String queue) {
    log.info("(push)message: {}, queue: {}", message, queue);
    this.rabbitTemplate.convertAndSend(queue, message);
  }
}
