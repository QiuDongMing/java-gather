package com.qdm.thread.demo.demo2.obser;

/**
 * @author qiudm
 * @date 2018/11/20 17:01
 * @desc 被观察者
 */
public interface IObservable {

    /**
     * 注册一个观察者
     * @param o
     */
    void registerObserver(IObserver o);

    /**
     * 移除一个观察者
     * @param o
     */
    void removeObserver(IObserver o);

    /**
     * 通知观察者
     * @param id         被通知的对象的id
     * @param result    通知的内容
     */
    void notifyObserver(String id, Result result);

}
