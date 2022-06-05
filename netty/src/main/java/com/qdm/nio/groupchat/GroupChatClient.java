package com.qdm.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GroupChatClient {

    //服务器端口
    private static final int SERVER_PORT = 6667;
    //服务器ip
    private static final String SERVER_HOST = "127.0.0.1";
    private Selector selector;
    private SocketChannel socketChannel;

    private String userName;

    public GroupChatClient() throws Exception {
        selector = Selector.open();
        //连接服务器
        socketChannel = socketChannel.open(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        //客户端的地址
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("client " + userName + " is ok");
    }

    //发送消息
    public void sendMsgInfo(String msg) {
        msg = userName + " send:" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readMsgInfo() {
        try {
            int readChannel = selector.select();
            if (readChannel > 0) {//有可用的通道

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        socketChannel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg);
                    }
                }
                iterator.remove();
            }
//            else {
//                System.out.println("no channel");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        GroupChatClient chatClient = new GroupChatClient();

        //启动一个线程,从读取服务端发送的数据
        new Thread(()->{
            while (true) {
                chatClient.readMsgInfo();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.next();
            chatClient.sendMsgInfo(msg);
        }


    }











}
