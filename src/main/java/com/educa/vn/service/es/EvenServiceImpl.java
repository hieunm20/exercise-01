package com.educa.vn.service.es;

import com.educa.vn.entity.Even;
import com.educa.vn.repository.es.EvenRepositoryEs;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Admin on 7/2/2021.
 */

@Slf4j
@RequiredArgsConstructor
public class EvenServiceImpl implements EvenService {
  
  private final EvenRepositoryEs repositoryEs;
  
  @Override
  public void create(Even even) {
    log.info("(create) even: {}", even);
    
    even.setCreatedAt(System.currentTimeMillis());
    repositoryEs.save(even);
  }
  
  @Override
  public Page<Even> filter(Pageable pageable) {
    return repositoryEs.findAll(pageable);
  }
  
  @Override
  public List<Even> findTop10ByCreatedAtOrderByDesc() {
    return repositoryEs.findTop10ByOrderByCreatedAtDesc();
  }
}
