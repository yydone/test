package com.yydone.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ProcessJobScheduleTest {

    @Test
    public void t() throws InterruptedException {

        System.out.println("start.........");
        Thread.sleep(5000000);

        System.out.println("end.........");
    }

}
