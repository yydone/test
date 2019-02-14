package com.yydone.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZkLockTest {
    private static ExecutorService service;
    static final CuratorFramework curator;
    static final InterProcessMutex zkMutex;

    static {
        curator = CuratorFrameworkFactory.newClient("10.6.124.17:2181,10.6.124.18:2181,10.6.124.19:2181", new RetryOneTime(2000));
        curator.start();
        zkMutex = new InterProcessMutex(curator, "/mutex");
    }

    public static void count(int threadNum, final int workers) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(threadNum);
        service = Executors.newFixedThreadPool(threadNum);
        long start = System.currentTimeMillis();
        for(int i=0; i< threadNum; ++i) {
            service.execute(new Runnable() {
                public void run() {
                    for(int i=0; i< workers; ++i) {
                        try {
                            zkMutex.acquire();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                zkMutex.release();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    latch.countDown();
                }
            });
        }
        service.shutdown();
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("Thread Num:" + threadNum + "workers per Thread:" + workers
                + " cost time:" + (end - start) + " avg" + (threadNum * workers)*1000/(end-start));
    }

    public static void main(String []args) throws Exception {
        ZkLockTest.count(1, 500);
        ZkLockTest.count(10, 500);
        ZkLockTest.count(20, 500);
        ZkLockTest.count(30, 500);
    }
}
