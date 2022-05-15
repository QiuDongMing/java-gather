package com.qdm.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用一个Channel完成文件的拷贝
 */
public class FileChannel03 {

    public static void main(String[] args) throws Exception {

        //输入流
        FileInputStream fis = new FileInputStream("D:\\QDM\\projects\\java-gather\\file\\file01.txt");
        FileChannel fileChannelRead = fis.getChannel();
        //输出流
        FileOutputStream fos = new FileOutputStream("D:\\QDM\\projects\\java-gather\\file\\file1Copy.txt");
        FileChannel fisChannelWrite = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            //将byteBuffer复位！！
            byteBuffer.clear();
            int read = fileChannelRead.read(byteBuffer);
            if (read == -1) {
                break;
            }
            //反转
            byteBuffer.flip();
            fisChannelWrite.write(byteBuffer);
        }
        fis.close();
        fos.close();
    }

}
