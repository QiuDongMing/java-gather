package com.qdm.nio.file;

import java.io.*;
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

        Long t3 = System.currentTimeMillis();
        readFile.ioReadFile("file.txt");
        Long t4 = System.currentTimeMillis();
        System.out.println("io:(t4-t3) = " + (t4-t3));

        Long t1 = System.currentTimeMillis();
        readFile.readFile("file.txt");
        Long t2 = System.currentTimeMillis();
        System.out.println("nio:(t2-t1) = " + (t2-t1));



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







    public void ioReadFile(String fileName) throws Exception {
        //1、获取通道(channel)
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String s = null;
        while ((s = reader.readLine()) != null) {

        }
        fis.close();
    }











}
