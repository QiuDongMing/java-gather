package com.coderme.design.observer.jdk;

import java.util.Observable;

/**
 * @author qiudm
 * @date 2019/2/18 11:35
 * @desc 被观察者
 * 场景：老师布置作业，关注了老师的，会收到老师布置的作业
 *
 */
public class Teacher extends Observable {


    public void addHomeWork(WorkInfo workInfo) {
        setChanged();
        notifyObservers(workInfo);
    }

}
