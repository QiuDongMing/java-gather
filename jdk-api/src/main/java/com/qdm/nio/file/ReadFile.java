package com.qdm.nio.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qiudm
 * @date 2018/8/16 23:06
 * @desc
 */
public class ReadFile {

    public static void main(String[] args) throws Exception {
        ReadFile readFile = new ReadFile();
//        readFile.writeFile("write.txt");
        readFile.readFile("file.txt");

    }

    public void readFile(String fileName) throws Exception {
        //1、获取通道(channel)
        FileInputStream fis = new FileInputStream(fileName);
        FileChannel channel = fis.getChannel();

        //2、创建缓冲区(buffer)
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3、将数据从通道读到缓冲区
        int read = channel.read(buffer);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                System.out.println("b = " + (char)b);
            }
            buffer.clear();
            read = channel.read(buffer);
        }

    }



    public void writeFile(String fileName) throws Exception {
        //获取通道
        FileOutputStream fos = new FileOutputStream( fileName );
        FileChannel channel = fos.getChannel();
        //创建缓存
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String[] strings = new String[]{"hello", "java"};
        for (String str : strings) {
            buffer.put(str.getBytes());
        }
        buffer.flip();
        channel.write(buffer);
    }


















}
