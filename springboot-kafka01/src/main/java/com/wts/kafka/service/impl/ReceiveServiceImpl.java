package com.wts.kafka.service.impl;

import com.wts.kafka.service.ReceiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 接受消息
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
@Slf4j
@Service
public class ReceiveServiceImpl implements ReceiveService {

    /**
     * 接受消息
     *
     * @param msg {@link String}
     * @author Kang Yong
     * @date 2022/7/1
     */
    @KafkaListener(id = "webGroup", topics = "topic_input")
    @Override
    public void receiveListen(String msg) {
        log.info("===input value:{}", msg);
    }
}
