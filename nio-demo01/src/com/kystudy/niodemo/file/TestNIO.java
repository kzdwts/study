package com.kystudy.niodemo.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2021/9/25
 * @since 1.0.0
 */
public class TestNIO {

    public static void main(String[] args) throws IOException {
        // 1、创建输出流
        FileOutputStream fos = new FileOutputStream("basic.txt");
        // 2、获取通道
        FileChannel fc = fos.getChannel();
        // 3、提供一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 4、数据暂存到缓冲区
        String msg = "hello,nio";
        byteBuffer.put(msg.getBytes());
        // 反转缓冲区
        byteBuffer.flip();

        // 5、把缓冲区写入通道中
        fc.write(byteBuffer);

        // 6、关闭
        fos.close();
    }

}
