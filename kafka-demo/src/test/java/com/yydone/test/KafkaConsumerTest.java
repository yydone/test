package com.yydone.test;

import com.yydone.test.demo.kafka.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class KafkaConsumerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void t() throws InterruptedException {
        for(int i=0;i<100;i++) {
            kafkaTemplate.send("foo", "test_20190103_" + i);
            TimeUnit.SECONDS.sleep(1);
        }
        RestTemplate template = new RestTemplate();
        TimeUnit.MINUTES.sleep(1);
    }
}
