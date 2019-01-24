package com.qdm.current.thread.demo.demo2.obser;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author qiudm
 * @date 2018/11/21 14:10
 * @desc
 */
public class MainApp {

    static int COUNT = 10000;

    static List<String> reqIds = Lists.newArrayList();

    public static void main(String[] args) {

        IObservable notifyObserver = new NotifyObserver();

        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
       //    System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
            new Thread(()->{
                try {
                    countDownLatch.await();//一直阻塞当前线程，直到计时器的值为0,保证同时并发
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String redId = UUID.randomUUID().toString();
                reqIds.add(redId);
                RequestObj requestObj = new RequestObj(redId, 5L);
                notifyObserver.registerObserver(requestObj);
                Result result = requestObj.getResult();
                System.out.println("JSON.toJSONString(result) = " + JSON.toJSONString(result));

            }).start();

            if (countDownLatch.getCount() == 1) {
                System.out.println(" start Time = " + System.currentTimeMillis());
            }
            countDownLatch.countDown();
        }


        //创建线程去模拟mq回调
        new Thread(()->{
            System.out.println(" = ===========================================mq" );
            int k=0;
            while (true) {
                try {
                    k++;
                    int size = reqIds.size();
                    System.out.println("");
                    if(size > 0) {
                        System.out.println("reqIds.size() = " + size);
                        String reqId = reqIds.get(size -1);
                        System.out.println("reqId = " + reqId + ",  reqIds.s="+size);
                        reqIds.remove(reqId);
                        if(reqId != null) {
                            Result result = new Result();
                            result.setResultCode(1);
                            result.setData("k="+k);
                            result.setResultMsg("msg");
                            notifyObserver.notifyObserver(reqId,result);
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }

        }).start();


        new Thread(()->{
            for (int j=0;j<10000;j++) {
             //   System.out.println("j = " + j);
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(()->{
                    String reqId = UUID.randomUUID().toString();
                    reqIds.add(reqId);
                    RequestObj requestObj = new RequestObj(reqId);
                    notifyObserver.registerObserver(requestObj);
                    Result result = requestObj.getResult();
                        System.out.println("res2 = " + JSON.toJSONString(result));
                }
                ).start();
            }
        }).start();




        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }















}
