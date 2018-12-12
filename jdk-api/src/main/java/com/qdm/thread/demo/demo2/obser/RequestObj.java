package com.qdm.thread.demo.demo2.obser;

import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/11/20 17:04
 * @desc 定义请求为观察者
 */
public class RequestObj implements IObserver {

    /**
     * 请求的id
     */
    private String reqId;

    /**
     * 等待时间 单位s 默认10s
     */
    private long waitTime;

    /**
     * 请求发起的时间
     */
    private long reqTime;

    /**
     * message Result
     */
    private Result result;

    public RequestObj(String reqId, long waitTime) {
        this.reqId = reqId;
        this.waitTime = waitTime;
        this.reqTime = System.currentTimeMillis();
    }

    public RequestObj(String reqId) {
        this(reqId, 10L);
    }

    @Override
    public void update(Result result) {
        this.result = result;
        synchronized (this) {
            this.notifyAll();
        }
    }

    @Override
    public String getId() {
        return this.reqId;
    }

    @Override
    public Result getResult() {

        synchronized (this) {
            try {
              //  System.out.println("reqTime=" + reqTime + ",reqId=" +reqId);
                this.wait(waitTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (result == null || Objects.equals(true, outTime())) {
            result = Result.build(null);
            result.setResultMsg("请求超时");
            result.setResultCode(0);
        }
        return result;
    }

    @Override
    public boolean outTime() {
        return System.currentTimeMillis() - this.reqTime > waitTime * 1000;
    }

}
