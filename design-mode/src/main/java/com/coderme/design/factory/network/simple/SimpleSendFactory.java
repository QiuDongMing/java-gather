package com.coderme.design.factory.network.simple;

import com.coderme.design.factory.network.MailSender;
import com.coderme.design.factory.network.Sender;
import com.coderme.design.factory.network.SmsSender;

import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/9/25 16:17
 * @desc 简单工厂模式
 */
public class SimpleSendFactory {

    public Sender produce(SenderType type) {
        Sender sender = null;
        if (Objects.equals(SenderType.MAIL, type)) {
            sender =  new MailSender();
        } else if (Objects.equals(SenderType.SMS, type)) {
            sender = new SmsSender();
        }
        return sender;
    }

}
