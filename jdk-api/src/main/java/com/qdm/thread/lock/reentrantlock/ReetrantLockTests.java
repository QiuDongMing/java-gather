package com.qdm.thread.lock.reentrantlock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qiudm
 * @date 2019/1/10 15:30
 * @desc
 */
public class ReetrantLockTests {

    ReentrantLock reentrantLock = new ReentrantLock();

    private int num = 0;

    @Test
    public void addNum() throws Exception {
        for (int i = 0; i < 500; i++) {
            new Thread(this::addNumVal).start();
        }
        Thread.sleep(3000L);
        System.out.println("num = " + num);
    }


    private void addNumVal() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < 1000; i++) {
                num++;
            }
        } finally {
            reentrantLock.unlock();
        }
    }





}
