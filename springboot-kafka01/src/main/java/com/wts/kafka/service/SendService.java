package com.wts.kafka.service;

/**
 * 发送消息
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
public interface SendService {

    /**
     * 发送消息
     *
     * @param msg {@link String}
     * @author Kang Yong
     * @date 2022/7/1
     */
    void sendFoo(String msg);
}
