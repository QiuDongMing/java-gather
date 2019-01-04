package com.qdm.thread.demo.product;

/**
 * @author qiudm
 * @date 2018/12/24 14:17
 * @desc
 */
public class Consumer extends Thread {

    private Package aPackage;

    public Consumer(Package aPackage) {
        this.aPackage = aPackage;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (aPackage) {
                if (aPackage.getSize() > 0) {
                    aPackage.remove();
                }
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
