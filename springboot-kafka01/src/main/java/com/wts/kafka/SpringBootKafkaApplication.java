package com.wts.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动
 *
 * @author Kang Yong
 * @date 2022/7/1
 * @since 1.0.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }
}
