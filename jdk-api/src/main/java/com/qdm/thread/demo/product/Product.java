package com.qdm.thread.demo.product;

import com.qdm.thread.data.Apple;

import java.util.Random;

/**
 * @author qiudm
 * @date 2018/12/24 14:08
 * @desc
 */
public class Product extends Thread {

    private Package aPackage;

    public Product(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (aPackage) {
                if (aPackage.getSize() < 20) {
                    Apple apple = new Apple();
                    apple.setName("appale:" + new Random().nextInt());
                    aPackage.add(apple);
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
