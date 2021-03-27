package com.coderme.design.proxy.network;

/**
 * @author qiudm
 * @date 2018/9/25 18:10
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(new BuyHouseImpl());
        buyHouseProxy.buyHouse();
    }

}
