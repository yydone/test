package com.yydone.dao.test;

import com.google.common.collect.Sets;
import com.yydone.dao.TransMapper;
import com.yydone.model.Trans;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TransMapperTest {

    @Autowired
    private TransMapper transMapper;

    @Test
    public void saveTest() throws InterruptedException {

        int num = 1000;
        long start = System.currentTimeMillis();
        Date date = new Date();
        String day = new SimpleDateFormat("yyyyMMdd").format(date);
        String time = new SimpleDateFormat("HHmmss").format(date);
        String[] dbs = {"00","01"};
        String[] tables = {"00","01","02","03","04","05","06","07","08","09"};
        Set<TransThread> set = Sets.newHashSet();
        for(int i=0;i<num;i++) {
            String db = dbs[new Random().nextInt(2)];
            String table = tables[new Random().nextInt(10)];
            String transId = day + time + String.format("%08d", i) + "000" + "00" + db + table;
            TransThread transThread = new TransThread();
            transThread.setTransId(transId);
            set.add(transThread);
        }
        System.out.println("生成订单号时间:" + (System.currentTimeMillis()-start));

        ExecutorService executorService = Executors.newFixedThreadPool(1500);
        start = System.currentTimeMillis();
        List<Future<String>> futures = executorService.invokeAll(set);
        long end = System.currentTimeMillis();
        System.out.println("插入数据库所花时间:" + (end - start));

        /*start = System.currentTimeMillis();
        int i;
        for(i=0;i<futures.size();i++) {
            System.out.println(futures.get(i));
        }
        end = System.currentTimeMillis();
        System.out.println(i+"个结果，所花时间:" + (end - start));*/

    }

    class TransThread implements Callable<String> {

        private String transId;

        public String getTransId() {
            return transId;
        }

        public void setTransId(String transId) {
            this.transId = transId;
        }

        public String call() throws Exception {
            Trans trans = new Trans();
            trans.setTransId(getTransId());
            trans.setOrgCode("Z1020020020011");
            trans.setTransAmt(100L);
            trans.setTransState("00");
            transMapper.save(trans);
            return trans.getTransId();
        }
    }

    @Test
    public void getTest() {
        String transId = "2018012315300012345678901230101";
        Trans trans = transMapper.get(transId);
        Assert.assertTrue(trans.getTransState().equals("00"));
    }

    @Test
    public void updateTest() {
        String transId = "2018012315300012345678901230101";
        transMapper.update(transId, "22", 2);
        Trans trans = transMapper.get(transId);
        Assert.assertTrue(trans.getTransState().equals("22"));
    }

    @Test
    public void t() {
        int str = 1;
        System.out.println(String.format("%010d", str));

        String time = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(time);

        for(int i=0;i<10;i++) {
            System.out.println(new Random().nextInt(2));
        }
    }

    @Test
    public void getListTest() {

        List<Trans> list = transMapper.getList("Z1020020020011",0);
        System.out.println(list.toString());

        list = transMapper.getList("Z1020020020011",50);
        System.out.println(list.toString());

        int count = transMapper.getCount("Z1020020020011");
        System.out.println("订单数为:"+ count);
    }
}
