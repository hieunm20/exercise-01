package com.educa.vn.service.rabbitmq;

/**
 * Created by Admin on 7/2/2021.
 */

public interface QueueService {
    void push(Object message, String queue);
}
