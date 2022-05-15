package com.qdm.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 可以直接在堆外内存中进行文件修改，而不需要进行一次文件拷贝
 */
public class MappedBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile accessFile = new RandomAccessFile("D:\\QDM\\projects\\java-gather\\file\\file01.txt", "rw");

        FileChannel channel = accessFile.getChannel();

        /**
         * 参数一： 使用读写模式
         * 参数二：可以修改的起始位置
         * 参数三：映射到内存的大小，即文件中有多少个字节的文件可以映射到内存
         * 可以修改的范围是第0-4字节
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) 'L');

        accessFile.close();

    }


}
