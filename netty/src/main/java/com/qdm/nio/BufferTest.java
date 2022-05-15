package com.qdm.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class BufferTest {

    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(5);
        for (int i = 0; i < 3; i++) {
            buffer.put(i*3);
        }
        //将buffer转换，读写切换
        buffer.flip();

        while (buffer.hasRemaining()) {
            int i = buffer.get();
            System.out.println("i = " + i);
        }
    }

}
