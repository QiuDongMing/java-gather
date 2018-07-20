package com.qdm.thread.lock;

import sun.misc.Lock;

/**
 * @author qiudm
 * @date 2018/7/12 21:07
 * @desc
 */
public class Counter {


    public static void main(String[] args) throws Exception {
        AddCounter c = new AddCounter();

            new Thread(new MyRunable(c)).start();
            new Thread(new MyRunable(c)).start();
            new Thread(new MyRunable(c)).start();
            new Thread(new MyRunable(c)).start();
            new Thread(new MyRunable(c)).start();
            new Thread(new MyRunable(c)).start();

        Thread.sleep(3000L);
        System.out.println("c = " + c.getCount());

    }
}


class AddCounter {


    private Lock lock = new Lock();

    private int count;

    public int inc() throws Exception {
        try {
//             lock.lock();
            count = count + 1;
//            lock.unlock();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }


    public int getCount() {
        return count;
    }
}


class MyRunable implements Runnable {

    AddCounter counter = null;

    MyRunable(AddCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            int inc = this.counter.inc();
            System.out.println("inc = " + inc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

