package com.wts.kafka.service.impl;

import com.wts.kafka.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 发送消息
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
@Slf4j
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    /**
     * 发送消息
     *
     * @param msg {@link String}
     * @author Kang Yong
     * @date 2022/7/1
     */
    @Override
    public void sendFoo(String msg) {
        log.info("===SEND_MSG===START===");
        this.kafkaTemplate.send("topic_input", msg);
        log.info("===SEND_MSG===END===");
    }
}
