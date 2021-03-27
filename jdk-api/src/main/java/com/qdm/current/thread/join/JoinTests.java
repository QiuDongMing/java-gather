package com.qdm.current.thread.join;

/**
 * @author qiudm
 * @date 2019/1/17 11:10
 * @desc
 */
public class JoinTests {


    public static void main(String[] args) throws Exception {

        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join();//

        System.out.println(" main thread");
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            System.out.println("t = "+Thread.currentThread().getName() + " i = " + i);
        }
    }
}
