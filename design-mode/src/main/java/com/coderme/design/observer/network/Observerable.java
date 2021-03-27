package com.coderme.design.observer.network;

/**
 * @author qiudm
 * @date 2018/9/25 16:57
 * @desc 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 */
public interface Observerable {
    /**
     * 添加观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObserver();

}
