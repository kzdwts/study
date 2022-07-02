package com.wts.kfk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * kafka server test
 *
 * @author Kang Yong
 * @date 2022/7/2
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
@EmbeddedKafka(count = 4, ports = {9092, 9093, 9094, 9095})
public class ApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        System.in.read();
    }
}
