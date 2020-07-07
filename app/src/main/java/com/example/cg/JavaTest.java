package com.example.cg;

import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class JavaTest {

    public static void main(String[] args) {

        // 集合测试
        //getListMap();

        // 线程池创建
        //threadPool();

        // 线程池结束
        //cancelAThread();

        System.out.println("CPU核数 = " + Runtime.getRuntime().availableProcessors());

    }


    /**
     * 集合类测试
     */
    public static void getListMap() {
        HashMap hashMap = new HashMap();// 异步的  允许空key value
        Hashtable hashtable = new Hashtable();// 同步的  不允许空key value

        hashMap.put(null, null);
        hashMap.put("1", "111");

        hashtable.put("null", "null");
        hashtable.put("1", "111");

        System.out.println(hashMap.toString());

        System.out.println(hashtable.toString());
    }


    /**
     * 线程池测试
     */
    public static void threadPool() {
        /** Java 中的线程池 **/
        // 一个可缓存线程池，如果线程池长度超过了处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        //newCacheThreadPool
        //一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        //newFixedThreadPool
        //一个定长线程池，支持定时及周期性任务执行
        //newScheduledThreadPool
        //一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有的任务按照指定的顺序（FIFO，LIFO，优先级）执行
        //newSingleThreadExecutor

        /** Android 中的线程池 **/

        // 自定义设置线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 5, 1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(50)
        );

        // FixedThreadPool (可重用固定线程数)
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // SingleThreadPool(单个核线的fixed)
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        // CachedThreadPool (按需创建)
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // ScheduledThreadPool(定时延时执行)
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 执行的任务
        for (int i = 0; i < 30; i++) {
            final int finali = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println("run : " + finali + "  当前线程：" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            // 自定义线程池
            //threadPoolExecutor.execute(runnable);

            //FixedThreadPool (可重用固定线程数)
            //fixedThreadPool.execute(runnable);

            //SingleThreadPool(单个核线的fixed)
            //singleThreadPool.execute(runnable);

            // CachedThreadPool (按需创建)
            //cachedThreadPool.execute(runnable);

            // ScheduledThreadPool(定时延时执行)
            scheduledThreadPool.schedule(runnable, 5, TimeUnit.SECONDS);

        }
    }


    /**
     * 线程池结束
     */
    private static void cancelAThread() {
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;

            Future<?> sub = executorService1.submit(() -> {
                try {
                    System.out.println(finalI);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                System.out.println(sub.get());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        executorService1.shutdown();


    }

/*
    三种阻塞队列：
    BlockingQueue workQueue = null;
    1. workQueue = new ArrayBlockingQueue<>(5);//基于数组的先进先出队列，有界
    2. workQueue = new LinkedBlockingQueue<>();//基于链表的先进先出队列，无界
    3. workQueue = new SynchronousQueue<>();//无缓冲的等待队列，无界
    四种拒绝策略：

    AbortPolicy（默认） ： 抛出异常，并删除任务。
    CallerRunsPolicy：用调用者所在的线程处理任务，此策略提供简单的反馈控制机制，能够减缓新任务的提交速度。
    DiscardPolicy：不执行任务，并将该任务删除
    DiscardOldestPolicy ：会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去。
    */

}
