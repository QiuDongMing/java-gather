package com.qdm.event;

import java.util.EventObject;

/**
 * @author qiudm
 * @date 2019/1/10 9:55
 * @desc  事件类,用于封装事件源及一些与事件相关的参数.
 */
public class MyEvent extends EventObject {

    private int sourceState;

    public MyEvent(Object source) {
        super(source);
        this.sourceState = ((EventSourceObject) source).getFlag();
    }

    public int getSourceState() {
        return sourceState;
    }

    public void setSourceState(int sourceState) {
        this.sourceState = sourceState;
    }
}
