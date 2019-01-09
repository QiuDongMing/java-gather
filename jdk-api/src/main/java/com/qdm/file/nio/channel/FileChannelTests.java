package com.qdm.file.nio.channel;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qiudm
 * @date 2019/1/9 14:41
 * @desc
 */
public class FileChannelTests {

    @Test
    public void FileChannelReadFile() {
        String fileName = "smallFile.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            //获取通道
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                //The buffer is used to drained
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void copyFile() throws Exception {
        String fileName = "smallfile.txt";
        int sufferIndex = fileName.lastIndexOf(".");
        String suffer = fileName.substring(sufferIndex);
        String newFileName = fileName.substring(0, sufferIndex) + "_copy" + suffer;
        //读文件
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        //写文件
        FileOutputStream fileOutputStream = new FileOutputStream(newFileName,true);
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        inputStreamChannel.transferTo(  0,
                                        inputStreamChannel.size(),
                                        fileOutputStreamChannel );

        inputStreamChannel.close();
        fileOutputStreamChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }









}
