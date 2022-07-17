package com.wts.config.property;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 安卓友盟参数配置
 *
 * @author Kang Yong
 * @date 2022/7/17
 * @since 1.0.0
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "param")
public class YmPushProperty implements Serializable {

    /**
     * 安卓参数
     */
    private List<ClientProperty> android;

    /**
     * ios参数
     */
    private List<ClientProperty> ios;

    @Data
    @ToString
    public static class ClientProperty implements Serializable {
        private String appCode;
        private String ymKey;
        private String ymSecret;
        private Boolean ymModel;
    }
}
