package com.coderme.design.proxy.cglibdynmic;

import com.coderme.design.proxy.network.BuyHouse;
import com.coderme.design.proxy.network.BuyHouseImpl;

/**
 * @author qiudm
 * @date 2018/9/25 18:28
 * @desc
 */
public class MainApp {

    public static void main(String[] args) {

        BuyHouse buyHouse = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
        buyHouseCglibProxy.buyHouse();

    }
}
