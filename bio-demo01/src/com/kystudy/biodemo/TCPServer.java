package com.kystudy.biodemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务端
 *
 * @author kangyong
 * @date 2021/9/23
 * @since 1.0.0
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocker对象
        ServerSocket ss = new ServerSocket(9999);

        while (true) {
            // 监听客户端
            Socket socket = ss.accept();
            // 从连接池取出
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[10];
            is.read(bytes);
            String clientIP = socket.getInetAddress().getHostAddress();
            System.out.println(clientIP + "说：" + new String(bytes).trim());

            // 回话
            OutputStream os = socket.getOutputStream();
            os.write("没钱".getBytes());
            ss.close();
        }
    }

}
