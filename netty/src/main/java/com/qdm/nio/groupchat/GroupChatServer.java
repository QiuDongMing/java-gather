package com.qdm.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServer {

    private Selector selector;

    private ServerSocketChannel listenerSocket;

    private static final int PORT = 6667;


    public GroupChatServer () {
        try {
            selector = Selector.open();
            //获取到ServerSocket
            listenerSocket =  ServerSocketChannel.open();
            listenerSocket.configureBlocking(false);
            //绑定端口
            listenerSocket.socket().bind(new InetSocketAddress(PORT));
            listenerSocket.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen() {
        try {
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel sc = listenerSocket.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        System.out.println("新的客户端上线:" + sc.getRemoteAddress().toString());
                    }

                    if (selectionKey.isReadable()) {
                        //sendMsg
                        readMsg(selectionKey);
                    }
                    iterator.remove();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    //接收客户端的消息，并实现转发
    public void readMsg(SelectionKey selectionKey) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);
            if (read > 0) {
                String msg = new String(byteBuffer.array());
                System.out.println("client send msg: " + msg);
                transferMsg2OtherClient(msg, socketChannel );
            }
        } catch (IOException e) {
            if (socketChannel != null) {
                try {
                    System.out.println(socketChannel.getRemoteAddress() + " offline");
                    selectionKey.channel();
                    socketChannel.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        }
    }

    //转发消息给其他客户端
    private void transferMsg2OtherClient(String msg, SocketChannel self) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel) {
                SocketChannel socketChannel = (SocketChannel) channel;
                if (socketChannel == self) {
                    continue;
                }
                socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
            }
        }
    }



    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }


}
