package com.qdm.event;

import java.util.EventListener;

/**
 * @author qiudm
 * @date 2019/1/10 10:13
 * @desc    事件监听器，实现java.util.EventListener接口。定义回调方法，将你想要做的事
 *  *       放到这个方法下,因为事件源发生相应的事件时会调用这个方法。
 */
public class StateChangeListener implements EventListener {

    public void handleEvent(MyEvent event) {
        System.out.println("触发状态改变事件。。。");
        System.out.println("当前事件源状态为：" + event.getSourceState());
        System.out.println("。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
