package com.educa.vn.entity;

import com.educa.vn.entity.base.EntityWithUpdater;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Admin on 7/2/2021.
 */
@Data
@Document(indexName = "index_even", type = "even")
public class Even extends EntityWithUpdater {
  
  private String name;
  private String description;
  
}
