package com.qdm.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel和transferFrom实现图片的拷贝
 */
public class FileChannel04 {

    public static void main(String[] args) throws Exception {

        String fileName = "D:\\QDM\\projects\\java-gather\\file\\jvm结构.png";
        String fileNameDst = "D:\\QDM\\projects\\java-gather\\file\\jvm结构Copy.png";
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileNameDst);

        fos.getChannel().transferFrom(fis.getChannel(), 0, fis.getChannel().size());

        fis.close();
        fos.close();
    }


}
