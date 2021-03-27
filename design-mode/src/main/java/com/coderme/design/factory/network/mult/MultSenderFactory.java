package com.coderme.design.factory.network.mult;

import com.coderme.design.factory.network.MailSender;
import com.coderme.design.factory.network.Sender;
import com.coderme.design.factory.network.SmsSender;

/**
 * @author qiudm
 * @date 2018/9/25 16:29
 * @desc 多个工厂方法模式
 */
public class MultSenderFactory {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

}
