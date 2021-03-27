package com.coderme.design.factory.network.abstracts;

import com.coderme.design.factory.network.Sender;

/**
 * @author qiudm
 * @date 2018/9/25 16:36
 * @desc 发送mail测试
 */
public class MainApp {
    public static void main(String[] args) {
        Factory factory = new SendMailFactory();
        Sender sender = factory.produce();
        sender.send();
    }
}
