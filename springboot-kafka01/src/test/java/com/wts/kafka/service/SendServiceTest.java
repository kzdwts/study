package com.wts.kafka.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SendServiceTest {

    @Autowired
    private SendService sendService;

    @Test
    public void sendFoo() throws IOException {
        this.sendService.sendFoo("第一条消息，hello world");

        System.in.read();
    }
}
