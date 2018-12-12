package com.qdm.thread.demo;


import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.UUID;

/**
 * @author qiudm
 * @date 2018/10/12 14:29
 * @desc
 */
public class ThreadTests {

    static Map<String, Message> messageMap = Maps.newConcurrentMap();

    private static final int INTERVAL = 2;

    public static void main(String[] args) throws Exception {

        Message message = new Message();
        String id = UUID.randomUUID().toString();
        message.setId(id);
        message.setName("name1");
        messageMap.put(id, message);

        Message message2 = new Message();
        String id2 = UUID.randomUUID().toString();
        message2.setId(id2);
        message2.setName("name12");
        messageMap.put(id2, message2);


        MyThread myThread1 = new MyThread(message);
        MyThread myThread2 = new MyThread(message2);
        ThreadNotify threadNotify = new ThreadNotify(message);
        myThread1.start();
        myThread2.start();
        threadNotify.start();


//        int i=0;
//
//        System.out.println("(i + 1) % INTERVAL = " + (i + 1) % INTERVAL);
//        System.out.println((i + 1) / INTERVAL - 1);
//        if ((i + 1) % INTERVAL == 0 && (i + 1) / INTERVAL - 1 < 1) {
//            int i1 = (i + 1) / INTERVAL - 1;
//            System.out.println("i1 = " + i1);
//
//            //AdMaterialDetailVO ad = adList.get((i + 1) / INTERVAL - 1);
////            if (Objects.nonNull(ad)) {
////                result.add(buildResultVO("10", ad));
////            }
//        }


        /*

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( new Date().toLocaleString() + " " +  Thread.currentThread().getName() + ":i=" + i);
            }
        }).start();


        new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                try {
                    Thread.sleep(600L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date().toLocaleString()  + " "  + Thread.currentThread().getName() + ":j=" + j);
            }
        }).start();


        new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                try {
                    Thread.sleep(900L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date().toLocaleString()  + " "  + Thread.currentThread().getName() + ":k=" + j);
            }
        }).start();

        */

    }

}
