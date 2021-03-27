package com.coderme.design.factory.network.abstracts;

import com.coderme.design.factory.network.MailSender;
import com.coderme.design.factory.network.Sender;

/**
 * @author qiudm
 * @date 2018/9/25 16:35
 * @desc
 */
public class SendMailFactory extends Factory {

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
