package com.qdm.thread.demo.demo2.obser;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;


/**
 * @author qiudm
 * @date 2018/11/20 17:32
 * @desc
 */
public class NotifyObserver implements IObservable {

    public NotifyObserver() {
        ClearObserverMap clearObserverMap = new ClearObserverMap();
        clearObserverMap.setDaemon(true);
        clearObserverMap.start();
    }

    /**
     * 存放所有的请求对象
     */
    private Map<String, IObserver> observerMap = Maps.newConcurrentMap();

    @Override
    public void registerObserver(IObserver o) {
        observerMap.put(o.getId(), o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observerMap.remove(o.getId());
    }

    @Override
    public void notifyObserver(String id, Result result) {
        IObserver iObserver = observerMap.get(id);
        if (Objects.nonNull(iObserver)) {
            iObserver.update(result);
            this.removeObserver(iObserver);
        }
    }


    class ClearObserverMap extends Thread {
        @Override
        public void run() {
            while (true) {
              //  System.out.println("time="+System.currentTimeMillis()+",  observerMapSize = " + observerMap.size());
                for (Map.Entry<String, IObserver> entry : observerMap.entrySet()) {
                    IObserver observer = entry.getValue();
                    if (observer.outTime()) {
                        removeObserver(observer);
                    }
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
