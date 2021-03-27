package com.coderme.design.observer.network;

/**
 * @author qiudm
 * @date 2018/9/25 17:02
 * @desc
 */
public class MainApp {


    public static void main(String[] args) {

        WechatServer wechatServer = new WechatServer();

        Observer wang = new User("wang");
        Observer li = new User("li");
        Observer qdm = new User("qdm");

        wechatServer.registerObserver(wang);
        wechatServer.registerObserver(li);
        wechatServer.registerObserver(qdm);
        wechatServer.setInformation("Information");

        System.out.println(" = = = = = = = =" );
        wechatServer.removeObserver(li);
        wechatServer.setInformation("Information_2");
        //wechatServer.notifyObserver();

    }




}



