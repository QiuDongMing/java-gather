package com.qdm.bio;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket();
        SocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        serverSocket.bind(address);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("a new client connected." );
            threadPool.execute(()-> {
                try {
                    handler(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }


    private static void handler(Socket socket) throws Exception {
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        while ((is.read(bytes) )!= -1) {
            String str = new String(bytes);
            System.out.println("Thread " + Thread.currentThread().getId() +" send: " + str);
        }
    }


}
