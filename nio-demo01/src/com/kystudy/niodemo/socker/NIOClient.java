package com.kystudy.niodemo.socker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 网络客户端程序
 *
 * @author Kang Yong
 * @date 2021/9/25
 * @since 1.0.0
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        // 得到一个网络通道
        SocketChannel channel = SocketChannel.open();

        // 设置非阻塞方式
        channel.configureBlocking(false);

        // 提供服务器端的ip和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);

        // 连接服务器端
        if (!channel.connect(address)) {
            // 未连上，换种方式继续连接
            while (!channel.finishConnect()) {
                System.out.println("Client:非阻塞方式，我还可以做其他的事");
            }
        }

        // 得到一个缓冲区并存入数据
        String msg = "hello server,can you jiegeiwodian money";
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());

        channel.write(byteBuffer);

        System.in.read();
    }

}
