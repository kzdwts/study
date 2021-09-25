package com.kystudy.biodemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 模拟客户端
 *
 * @author kangyong
 * @date 2021/9/23
 * @since 1.0.0
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 9999);

        OutputStream os = s.getOutputStream();
        System.out.println("请输入：");
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        os.write(msg.getBytes());

        InputStream is = s.getInputStream();
        byte[] bytes = new byte[20];
        is.read(bytes);
        System.out.println("老板说：" + new String(bytes).trim());

        s.close();
    }
}
