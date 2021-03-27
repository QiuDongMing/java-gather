package com.qdm.netty.demo3;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author qiudm
 * @date 2018/9/25 13:57
 * @desc
 */
public class ByteBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        byte[] bytes = "hello world".getBytes();
        buffer = ByteBuffer.wrap(bytes);
        print(buffer);
        byte b = 1;
        buffer.put(b);
        print(buffer);

    }


    private static void print(Buffer buffer) {
        System.out.printf("capacity():" + buffer.capacity() +
                ", hasArray():" + buffer.hasArray() +
                ", isDirect():" + buffer.isDirect() +
                ", isReadOnly():" + buffer.isReadOnly() +
                ", limit():" + buffer.limit() +
                ", position():" + buffer.position() +
                ", hasRemaining():" + buffer.hasRemaining() +
                ", remaining():" + buffer.remaining() +
                ", arrayOffset():" + buffer.arrayOffset()
        );
        System.out.println();
    }

}
