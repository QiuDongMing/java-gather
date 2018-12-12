package com.qdm.thread.demo;

import com.alibaba.fastjson.JSON;

/**
 * @author qiudm
 * @date 2018/11/20 15:59
 * @desc
 */
public class MyThread extends Thread {

    private Message message;

    public MyThread(Message message) {
        this.message = message;
    }


    @Override
    public void run() {
        synchronized (message) {
            try {
                long l1 = System.currentTimeMillis();
                message.wait(10000L);
                System.out.println("time:" + (System.currentTimeMillis() - l1) / 1000 + "  message = " + JSON.toJSONString(message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
