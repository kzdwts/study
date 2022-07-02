package com.wts.kafka.service;

/**
 * 接受消息
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
public interface ReceiveService {

    /**
     * 接受消息
     *
     * @param msg {@link String}
     * @author Kang Yong
     * @date 2022/7/1
     */
    void receiveListen(String msg);
}
