package com.yydone.demo.test.mapper;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.BankCardRepository;
import com.yydone.demo.dal.model.BankCardNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BankCardRepositoryTest {

    @Autowired
    private BankCardRepository bankCardRepository;


    @Test
    public void save() {
        BankCardNode bankCardNode = new BankCardNode();
        bankCardNode.setBankCardNo("6222022001211438163");
        bankCardNode.setBankCode("ICBC");
        bankCardNode.setBankCardMobile("13800138000");
        bankCardRepository.save(bankCardNode);
    }


}
