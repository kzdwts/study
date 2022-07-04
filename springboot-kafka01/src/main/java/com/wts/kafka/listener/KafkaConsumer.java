package com.wts.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Kang Yong
 * @date 2022/7/4
 * @since 1.0.0
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "kafkaLogTest")
    public void listen1(ConsumerRecord<?, ?> record) {
        System.out.printf("监听到消息：" + record.topic() + "----" + record.value() + "\n");
    }


    @KafkaListener(topics = "bizLogTest")
    public void listen2(ConsumerRecord<?, ?> record) {
        System.out.printf("监听到消息：" + record.topic() + "----" + record.value() + "\n");
    }
}
