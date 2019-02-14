package com.yydone.test;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.util.ShardingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@JobHandler(value="xxlJobDemo")
public class ProcessJobSchedule extends IJobHandler {

    @Autowired
    private XxlJobExecutor xxlJobExecutor;

    @Override
    public ReturnT<String> execute(String s) throws Exception {

        System.out.println("收到定时任务"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("开始处理任务");
        String [] dbs = {"00","01"};
        System.out.println("需要处理的数据库为："+ dbs);

        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        System.out.println("当前分片序号为："+shardingVO.getIndex());

        if(shardingVO.getIndex()<dbs.length) {
            String db = dbs[shardingVO.getIndex()];
            System.out.println("当前分片处理数据库为:" + db);
            System.out.println("处理中,处理时长需要70s");
           // Thread.sleep(70000);
            System.out.println("处理完成:"+db);
        } else {
            System.out.println("当前分片:"+ shardingVO.getIndex()+"无须处理");
        }

        Thread.sleep(5000);

        return SUCCESS;
    }
}
