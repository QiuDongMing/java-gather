package com.qdm.current.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author qiudm
 * @date 2018/7/19 10:37
 * @desc 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 *       叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。我们暂
 *       且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int N = 4; //指让多少个线程或者任务等待至barrier状态
        /**
         * demo1
         */
//      CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        /**
         * demo2:当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行Runnable
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N,()->
            System.out.println("当前线程" + Thread.currentThread().getName() +"执行后续操作" )
        );

        for (int i = 0; i < N; i++) {
            new Writer(cyclicBarrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据" );
            try {
                //Thread.sleep(3000);
                System.out.println("线程" + Thread.currentThread().getName()+"写入完毕" );
                cyclicBarrier.await();//线程就处于barrier了
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }



}
