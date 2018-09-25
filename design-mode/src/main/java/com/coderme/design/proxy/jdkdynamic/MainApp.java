package com.coderme.design.proxy.jdkdynamic;

import com.coderme.design.proxy.network.BuyHouse;
import com.coderme.design.proxy.network.BuyHouseImpl;

import java.lang.reflect.Proxy;

/**
 * @author qiudm
 * @date 2018/9/25 18:18
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse buyHouse1 = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        buyHouse1.buyHouse();
    }

}
