package com.educa.vn.listener;

import com.educa.vn.entity.Even;
import com.educa.vn.service.es.EvenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 7/2/2021.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EvenListener {
  
  private final EvenService evenService;
  
  @RabbitListener(queues = "${application.queue.even.even-listener}")
  public void evenListener(Even even){
    log.info("(evenListener) even: {}", even);
  
    evenService.create(even);
  }
}
