package com.wts.service.Impl;

import com.wts.config.property.YmPushProperty;
import com.wts.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 推送业务实现
 *
 * @author Kang Yong
 * @date 2022/7/17
 * @since 1.0.0
 */
@Service
public class PushServiceImpl implements PushService {

    @Autowired
    private YmPushProperty ymPushProperty;


    @Override
    public void print() {
        List<YmPushProperty.ClientProperty> androidList = ymPushProperty.getAndroid();
        List<YmPushProperty.ClientProperty> iosList = ymPushProperty.getIos();

        androidList.forEach(System.out::println);
        iosList.forEach(System.out::println);
    }
}
