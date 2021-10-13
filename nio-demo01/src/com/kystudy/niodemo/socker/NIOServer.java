package com.kystudy.niodemo.socker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 服务器端程序
 *
 * @author Kang Yong
 * @date 2021/10/7
 * @since 1.0.0
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        // 1、创建一个服务端对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2、创建一个监视器
        Selector selector = Selector.open();

        // 3、绑定一个端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 4、设置非阻塞方式
        serverSocketChannel.configureBlocking(false);

        // 5、把serverSocketChnnel对象注册给selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 工作
        while (true) {
            // 6.1、监控客户端
            if (selector.select(2000) == 0) {
                // 没有监听到通道
                System.out.println("server:没有客户端搭理我，我就干点别的事");
                continue;
            }

            // 6.2、得到selectorKey，判断事件类型
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // 客户端连接事件
                    System.out.println("OP_ACCEPT");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()) {
                    // 客户端读取数据事件
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发来的数据：" + new String(buffer.array()));
                }

                // 6.3、手动从集合中移除当前key，防止重复处理
                keyIterator.remove();
            }
        }

    }
}
