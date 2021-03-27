package com.qdm.current.thread.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * @author qiudm
 * @date 2018/9/26 14:32
 * @desc
 */
public class Demo1 {

    private static final int corePoolSize = 1;
    private static final int maximumPoolSize = 25;
    private static final long keepAliveTime = 10;
    private static final BlockingQueue queue = new LinkedBlockingDeque(10);



    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                TimeUnit.SECONDS, queue);

        executor.execute(() -> getName());
        Future<Integer> future = executor.submit(() -> getAge());


//        try {
////            Integer age = future.get();//阻塞
////            System.out.println("age = " + age);
//            executor.execute(() -> getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        System.out.println("getActiveCount = " + executor.getActiveCount());
        System.out.println("executor.getLargestPoolSize() = " + executor.getLargestPoolSize());
        System.out.println("executor.getTaskCount() = " + executor.getTaskCount());
        Thread.sleep(1000L);
        System.out.println("executor.getCompletedTaskCount() = " + executor.getCompletedTaskCount());
        Thread.sleep(3000L);
        System.out.println("executor.getCompletedTaskCount2() = " + executor.getCompletedTaskCount());

    }


    private static void getName() {
        System.out.println("getName " );
    }

    private static int getAge() throws InterruptedException {
        Thread.sleep(2000L);
        return 10;
    }


}
