package com.qdm.current.thread.demo;

/**
 * @author qiudm
 * @date 2018/11/20 16:19
 * @desc
 */
public class ThreadNotify extends Thread {

    private Message message;

   public ThreadNotify(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            message.notifyAll();
        }

    }
}
