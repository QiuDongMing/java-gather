package com.qdm.thread.lock.synchronizeds;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/10 14:55
 * @desc
 */
public class SynchronizedTests {

    private int num = 0;


    @Test
    public void addNum() throws Exception {

        for (int i = 0; i < 5000; i++) {
            new Thread(this::addNumVal).start();
        }
        Thread.sleep(3000L);

        System.out.println("num=" + num);
    }


    private synchronized void addNumVal() {
        for (int i = 0; i < 1000; i++) {
            num ++;
        }
    }


}


