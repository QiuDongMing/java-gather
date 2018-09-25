package com.coderme.design.factory.network;

/**
 * @author qiudm
 * @date 2018/9/25 16:15
 * @desc
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("send mail");
    }
}
