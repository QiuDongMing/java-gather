package com.qdm.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务端
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("client has not finish connect");
            }
            //连接成功
            ByteBuffer byteBuffer = ByteBuffer.wrap("hello server".getBytes());
            //发送数据，将buffer数据写入channel
            socketChannel.write(byteBuffer);
            System.in.read();
        }

    }
}
