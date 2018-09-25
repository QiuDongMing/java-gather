package com.coderme.design.observer.network;

/**
 * @author qiudm
 * @date 2018/9/25 17:01
 * @desc 定义具体观察者，微信公众号的具体观察者为用户User
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
