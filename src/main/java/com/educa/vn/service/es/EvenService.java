package com.educa.vn.service.es;

import com.educa.vn.entity.Even;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Admin on 7/2/2021.
 */

public interface EvenService {
  
  void create(Even even);
  
  Page<Even> filter(Pageable pageable);
  
  List<Even> findTop10ByCreatedAtOrderByDesc();
}
