package com.kystudy.niodemo.file;

import org.junit.jupiter.api.Test;

import java.io.*;
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

    /**
     * 写数据到文件
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
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

    /**
     * 从文件读数据
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        File file = new File("basic.txt");
        // 1、获取输入流
        FileInputStream fis = new FileInputStream(file);
        // 2、获取通道
        FileChannel fc = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 从通道读取数据并存到缓冲区中
        fc.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));

        fc.close();
    }

    /**
     * 使用nio实现文件复制
     */
    @Test
    public void test03CopyFile() throws IOException {
        // 1、创建两个流
        FileInputStream fis = new FileInputStream("basic.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Temp\\text.txt");

        // 2、得到两个通道
        FileChannel sourceFC = fis.getChannel();
        FileChannel destFC = fos.getChannel();

        // 3、复制
//        sourceFC.transferTo(0, sourceFC.size(), destFC);
        destFC.transferFrom(sourceFC, 0, sourceFC.size());

    }

}
