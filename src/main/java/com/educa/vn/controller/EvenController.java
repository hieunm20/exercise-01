package com.educa.vn.controller;

import com.educa.vn.entity.Even;
import com.educa.vn.service.es.EvenService;
import com.educa.vn.service.rabbitmq.QueueService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 7/2/2021.
 */

@Slf4j
@RestController
@RequestMapping("/even")
@RequiredArgsConstructor
public class EvenController {
  
  @Value("${application.queue.even.even-listener}")
  private String evenListenerQueue;
  
  private final QueueService queueService;
  private final EvenService evenService;
  
  @PostMapping("/create")
  public ResponseEntity<Void> create(@RequestBody Even even) {
    log.info("(create) even: {}", even);
    
    queueService.push(even, evenListenerQueue);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/lastest")
  public ResponseEntity<List<Even>> listEven() {
    log.info("(listEven) called");
    
    List<Even> evens = evenService.findTop10ByCreatedAtOrderByDesc();
    return ResponseEntity.ok(evens);
  }
  
  @GetMapping("/filter")
  public ResponseEntity<Page<Even>> filter(@RequestParam(value = "page") int page,
      @RequestParam(value = "size") int size) {
    log.info("(filter) page: {}, size: {}", page, size);
    
    Pageable pageable = PageRequest.of(page, size);
    Page<Even> evens = evenService.filter(pageable);
    return ResponseEntity.ok(evens);
  }
}
