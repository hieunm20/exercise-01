package com.educa.vn.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 7/2/2021.
 */
@Configuration
public class QueueConfiguration {

    @Value("${application.queue.even.even-listener}")
    private String evenListenerQueue;

    @Bean
    public Queue evenListenerQueue() {
        return new Queue(evenListenerQueue);
    }
}
