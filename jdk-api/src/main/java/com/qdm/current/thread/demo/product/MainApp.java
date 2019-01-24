package com.qdm.current.thread.demo.product;

/**
 * @author qiudm
 * @date 2018/12/24 14:07
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {

        Package packages = new Package();

        Product product = new Product(packages);
        Consumer consumer = new Consumer(packages);
        product.start();
        consumer.start();

    }


}
