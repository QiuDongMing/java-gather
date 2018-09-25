package com.coderme.design.factory.network;

/**
 * @author qiudm
 * @date 2018/9/25 16:16
 * @desc
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("send sms" );
    }
}
