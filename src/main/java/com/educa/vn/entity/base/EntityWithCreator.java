package com.educa.vn.entity.base;

import lombok.Data;

/**
 * Created by Admin on 7/2/2021.
 */
@Data
public class EntityWithCreator extends BaseEntity{
  
  protected Long createdAt;
}
