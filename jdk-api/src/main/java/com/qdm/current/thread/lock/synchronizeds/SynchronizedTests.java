package com.qdm.current.thread.lock.synchronizeds;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author qiudm
 * @date 2019/1/10 14:55
 * @desc
 */
public class SynchronizedTests {

    private int num = 0;

    private Integer count = 0;


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


    @Test
    public void multiThreadTest() throws Exception {
        int COUNT = 20;
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println("线程开始"+ Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        Thread.sleep(2000);
        for (int i = 0; i < COUNT; i++) {
            countDownLatch.countDown();
        }

    }






}


