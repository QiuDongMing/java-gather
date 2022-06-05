package com.qdm.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册到selector,事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //等待1s，如果没有事件发生，就返回
            int select = selector.select(1000);
            if (select == 0) {//没有事件发生
                System.out.println(" server wait 1 sec, no connect ");
                continue;
            }

            //获取到相关的SelectionKey集合,表示获取到关注的事件集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                //根据key对应的通道发生的事件，做相应的处理
                if (selectionKey.isAcceptable()) {//有新的客户端连接
                    //为该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("新的客户端连接, code=" + socketChannel.hashCode());
                    //将当前的SocketChannel注册到selector上, 关注事件为读的事件，给该SocketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (selectionKey.isReadable()) {//发生读的事件
                    //通过SelectionKey反向获取SocketChannel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //获取到该socketChannel获取的Buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    //将当前channel的数据读取到buffer
                    socketChannel.read(byteBuffer);
                    System.out.println("client data: " + new String(byteBuffer.array()));
                }

                //手动从当前集合中remove当前的SelectionKey，防止重复操作
                keyIterator.remove();
            }

        }


    }
}
