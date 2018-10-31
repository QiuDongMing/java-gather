package com.qdm.thread.demo;

import java.util.Date;
import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/10/12 14:29
 * @desc
 */
public class ThreadTests {

    private static final int INTERVAL = 2;

    public static void main(String[] args) throws Exception {
        int i=0;

        System.out.println("(i + 1) % INTERVAL = " + (i + 1) % INTERVAL);
        System.out.println((i + 1) / INTERVAL - 1);
        if ((i + 1) % INTERVAL == 0 && (i + 1) / INTERVAL - 1 < 1) {
            int i1 = (i + 1) / INTERVAL - 1;
            System.out.println("i1 = " + i1);

            //AdMaterialDetailVO ad = adList.get((i + 1) / INTERVAL - 1);
//            if (Objects.nonNull(ad)) {
//                result.add(buildResultVO("10", ad));
//            }
        }


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
