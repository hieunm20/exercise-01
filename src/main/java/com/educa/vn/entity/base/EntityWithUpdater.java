package com.educa.vn.entity.base;

import lombok.Data;

/**
 * Created by Admin on 7/2/2021.
 */
@Data
public class EntityWithUpdater extends EntityWithCreator {
  
  protected long updatedAt;
}
