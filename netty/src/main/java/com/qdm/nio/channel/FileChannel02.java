package com.qdm.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件读取内容
 */
public class FileChannel02 {

    public static void main(String[] args) throws Exception {

        File file = new File("D:\\QDM\\projects\\java-gather\\file\\file01.txt");
        FileInputStream fis = new FileInputStream(file);

        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //通道的数据读入到缓冲区
        fileChannel.read(byteBuffer);

        System.out.println("str=" + new String(byteBuffer.array()));

        fis.close();
    }

}
