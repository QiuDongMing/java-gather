package com.qdm.current.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author qiudm
 * @date 2018/7/19 10:26
 * @desc CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，
 * 它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程1执行： = " + Thread.currentThread().getName());
                Thread.sleep(3000L);
                System.out.println("子线程1执行完成： = " + Thread.currentThread().getName());
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                System.out.println("子线程2执行： = " + Thread.currentThread().getName());
                Thread.sleep(3000L);
                System.out.println("子线程2执行完成： = " + Thread.currentThread().getName());
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        try {
            System.out.println("等待两个子线程执行完成");
            System.out.println("cdl1 = " + cdl.getCount());
            cdl.await();
            System.out.println("cdl2 = " + cdl.getCount());
            System.out.println("两个子线程执行完成");
            System.out.println(" 执行主线程 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
