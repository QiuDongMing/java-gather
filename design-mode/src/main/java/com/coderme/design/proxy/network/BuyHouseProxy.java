package com.coderme.design.proxy.network;

/**
 * @author qiudm
 * @date 2018/9/25 18:09
 * @desc
 */
public class BuyHouseProxy implements BuyHouse {

    private BuyHouseImpl buyHouse;

    BuyHouseProxy(BuyHouseImpl buyHouse) {
        this.buyHouse = buyHouse;
    }


    @Override
    public void buyHouse() {
        System.out.println("代理类买房前" );
        buyHouse.buyHouse();
        System.out.println("代理类买房后" );
    }
}
