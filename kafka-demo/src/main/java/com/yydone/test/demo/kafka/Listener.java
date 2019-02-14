package com.yydone.test.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class Listener {

    @KafkaListener(groupId = "0", topics = "foo")
    public void listen1(ConsumerRecord<String, String> record) {
        log.info(record.toString());
    }
}
