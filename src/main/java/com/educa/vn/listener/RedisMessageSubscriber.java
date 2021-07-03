package com.educa.vn.listener;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by Hieunm on 3/7/2021.
 */
@Service
public class RedisMessageSubscriber implements MessageListener {
  
  public void onMessage(Message message, byte[] pattern) {
    System.out.println("Message received: " + message);
  }
}