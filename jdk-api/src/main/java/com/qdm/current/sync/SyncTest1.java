package com.qdm.current.sync;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author qiudm
 * @date 2018/12/14 17:04
 * @desc
 */
public class SyncTest1 {

    Lock lock = new ReentrantLock();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    int count = 0;

    void increment() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        lock.lock();
        readWriteLock.writeLock().lock();
        try {
            count = count + 1;
        } finally {
//            lock.unlock();
            readWriteLock.writeLock().unlock();
        }

    }


    public void countResult() {

        ExecutorService executor = Executors.newFixedThreadPool(100);

        IntStream.range(0, 100000)
                .forEach(i -> executor.submit(this::increment));

        stop(executor);

        System.out.println("count = " + count);

    }


    public static void main(String[] args) {
//        SyncTest1 syncTest1 = new SyncTest1();
//        syncTest1.countResult();

//        IntStream.range(0, 20).forEach(index->System.out.println(index));

//        List<String> list = Lists.newArrayList("a1", "a2", "b1", "b2", "b3", "c1", "c2");
//        list.stream().filter(s -> s.contains("2")).forEach(System.out::println);
//
        List<String> list2 = Lists.newArrayList("1", "2", "3", "4", null);
        List<Long> collect = list2.stream().filter(s->StringUtils.isNotEmpty(s)).map(Long::new).collect(Collectors.toList());
        collect.stream().forEach(System.out::print);

    }


    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }



}
