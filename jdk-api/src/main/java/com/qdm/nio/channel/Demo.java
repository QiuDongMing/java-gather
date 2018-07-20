package com.qdm.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qiudm
 * @date 2018/7/3 10:11
 * @desc
 */
public class Demo {

    public static void main(String[] args) {

        try {
            new Demo().readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void readFile() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "r");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }


    public void demoPath() {

        Path p = Paths.get("x");


    }



















}
