package com.coderme.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author qiudm
 * @date 2019/2/18 11:35
 * @desc 观察者，接收被观察者（Teacher）的通知
 */
public class Student implements Observer {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " get Teacher info:" + arg.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
