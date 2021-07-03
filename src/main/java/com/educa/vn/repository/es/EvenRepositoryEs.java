package com.educa.vn.repository.es;

import com.educa.vn.entity.Even;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Admin on 7/2/2021.
 */

public interface EvenRepositoryEs extends ElasticsearchRepository<Even, String> {
  
  List<Even> findTop10ByOrderByCreatedAtDesc();
}
