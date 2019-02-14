package com.yydone.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ForkJoinPoolTest {

    public static void main(String []args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(500, 2000, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000));
        int threadNum = 50;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        long Tstart = System.currentTimeMillis();
        for(int i=0; i< threadNum; ++i) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ForkJoinPool pool = new ForkJoinPool(5);
                    BigDecimal x = new BigDecimal("8");
                    BigDecimal y = new BigDecimal("3");
                    List<Character> list = Arrays.asList('+', '-', '*', '/', '+', '-', '*', '/', '+', '-', '*', '/');
                    JoinTask task = new JoinTask(x, y, list);
                    //long start = System.currentTimeMillis();
                    BigDecimal result = pool.invoke(task);
                    //long end = System.currentTimeMillis();
                    //System.out.println(result + " time is: " + (end - start));
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();
        latch.await();
        long endT = System.currentTimeMillis();
        System.out.println("=========================" + (endT-Tstart));
    }
}
