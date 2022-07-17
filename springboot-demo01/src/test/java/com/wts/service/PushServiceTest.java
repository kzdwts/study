package com.wts.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试类
 *
 * @author Kang Yong
 * @date 2022/7/17
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PushServiceTest {

    @Autowired
    private PushService pushService;

    @Test
    public void print() {
        pushService.print();
    }
}