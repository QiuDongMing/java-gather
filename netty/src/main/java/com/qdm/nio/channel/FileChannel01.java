package com.qdm.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * 将字符串写入到文件
 *
 * ByteBuffer --> FileChannel(FileOutPutStream)
 */
public class FileChannel01 {

    public static void main(String[] args) throws Exception {

        String s = "hello QDM,你好！";

        //原始的文件输出流，被FileChannel包装
        FileOutputStream fos = new FileOutputStream("D:\\QDM\\projects\\java-gather\\file\\file01.txt");
        //获取fileChannel，实现是FileChannelImpl
        FileChannel fileChannel = fos.getChannel();
        //创建一个ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //字符串写入到byteBuffer
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();

        //写入byteBuffer到channel
        fileChannel.write(byteBuffer);
        fos.close();
    }


}
