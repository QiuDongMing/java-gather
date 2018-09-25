package com.coderme.design.factory.network.abstracts;

import com.coderme.design.factory.network.Sender;
import com.coderme.design.factory.network.SmsSender;

/**
 * @author qiudm
 * @date 2018/9/25 16:35
 * @desc
 */
public class SendSmsFactory extends Factory {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
