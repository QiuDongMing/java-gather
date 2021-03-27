package com.coderme.design.observer.network;

/**
 * @author qiudm
 * @date 2018/9/25 16:57
 * @desc  抽象观察者
 *        定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 */
public interface Observer {

    void update(String message);

}
