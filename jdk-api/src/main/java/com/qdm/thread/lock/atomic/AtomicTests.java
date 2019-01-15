package com.qdm.thread.lock.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qiudm
 * @date 2019/1/10 15:35
 * @desc
 */
public class AtomicTests {
    private AtomicInteger num = new AtomicInteger(0);

    @Test
    public void addNum() throws Exception{
        for (int i = 0; i < 5000; i++) {
            new Thread(this::addNumVal).start();
        }
        Thread.sleep(3000L);
        System.out.println("num = " + num.get());
    }


    private void addNumVal() {
        for (int i = 0; i < 1000; i++) {
            num.getAndAdd(1);
        }
    }

}

