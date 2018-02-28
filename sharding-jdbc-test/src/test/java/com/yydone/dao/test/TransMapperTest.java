package com.yydone.dao.test;

import com.google.common.collect.Sets;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yydone.dao.TransMapper;
import com.yydone.model.Trans;
import io.shardingjdbc.core.api.HintManager;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.NoneShardingStrategyConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.constant.ShardingOperator;
import io.shardingjdbc.spring.datasource.SpringShardingDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TransMapperTest {

    @Autowired
    private TransMapper transMapper;
    @Autowired
    private Map<String, ComboPooledDataSource> dataSourceMap;

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

    }

    @Test
    public void updateAmtTest() throws InterruptedException {
        int num = 100000;
        Set<UpdateTransThread> set = Sets.newHashSet();
        String [] transIds = {"2018020108580600000003000000107","2018020108580600000004000000108"};
        for(int i=0;i<num;i++) {
            UpdateTransThread transThread = new UpdateTransThread();
            String transId = transIds[new Random().nextInt(2)];
            transThread.setTransId(transId);
            set.add(transThread);
        }
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        List<Future<Integer>> futures = executorService.invokeAll(set);
        long end = System.currentTimeMillis();

        System.out.println("更新数据库所花时间:" + (end - start));
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

    class UpdateTransThread implements Callable<Integer> {

        private String transId;

        public String getTransId() {
            return transId;
        }

        public void setTransId(String transId) {
            this.transId = transId;
        }

        public Integer call() throws Exception {
            return transMapper.updateAmt(transId, 100L);
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

    @Test
    public void getCountDb0() {
        System.out.println("=======");
        System.out.println(dataSourceMap.toString());

        while(true) {
            HintManager hintManager = HintManager.getInstance();
            hintManager.addDatabaseShardingValue("t_trans","trans_id","0000");
            hintManager.addTableShardingValue("t_trans","trans_id","00");
            List<Trans> trans = transMapper.getLists("00");
            hintManager.close();
            if(trans!=null && trans.size()>0) {
                for(Trans t : trans) {
                    System.out.println(t.toString());
                    transMapper.update(t.getTransId(), "01", t.getVersion()+1);
                }
            } else {
                break;
            }
        }
    }
}
