package com.yydone.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MyTask {


    public static void main(String []args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(50, 200, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000));
        int threadNum = 500;
        final CountDownLatch latch = new CountDownLatch(threadNum);
        long Tstart = System.currentTimeMillis();
        for(int i=0; i< threadNum; ++i) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //long start = System.currentTimeMillis();
                    BigDecimal x = new BigDecimal("8");
                    BigDecimal y = new BigDecimal("2");
                    final Executor executor = new ForkJoinPool(8);
                    List<Character> ruleList = Arrays.asList('+', '-', '*', '/');
                    List<BigDecimal> resList = new ArrayList<>();
                    // 并行计算规则组
                    CompletableFuture[] cfs =
                            ruleList.stream()
                                    .map(operate -> CompletableFuture.supplyAsync(() -> calcResult(x, y, operate), executor).whenComplete((result, e)-> resList.add(result))
                                    ).toArray(CompletableFuture[]::new);
                    // 等待计算完成
                    CompletableFuture.allOf(cfs).join();
                    //long end = System.currentTimeMillis();
                    //System.out.println("========" + (end-start));
/*                    resList.stream().forEach(res -> {
                        System.out.println(res);
                    });*/
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();
        latch.await();
        long endT = System.currentTimeMillis();
        System.out.println("=========================" + (endT-Tstart));

        TimeUnit.MINUTES.sleep(5);


    }

    private static BigDecimal calcResult(BigDecimal x, BigDecimal y, char operator) {
        BigDecimal result;
        switch (operator) {
            case '+':
                result = x.add(y);
                break;
            case '-':
                result = x.subtract(y);
                break;
            case '*':
                result = x.multiply(y);
                break;
            case '/':
                result = x.divide(y, 0, RoundingMode.FLOOR);
                break;
            default:
                result = BigDecimal.ZERO;
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
