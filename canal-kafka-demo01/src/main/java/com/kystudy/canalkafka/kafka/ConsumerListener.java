package com.kystudy.canalkafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * TODO description.
 *
 * @author kangyong
 * @date 2021/9/23
 * @since 1.0.0
 */
@Component
public class ConsumerListener {

    /**
     * 监听kafka消息
     *
     * @param info
     */
    @KafkaListener(id = "example", topics = "example")
    public void listen(String info) {
        System.out.println("接收到kafka消息：" + info);
    }
}
