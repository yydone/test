package com.yydone.demo.test.mapper;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.ContractorRepository;
import com.yydone.demo.dal.mapper.MobileRepository;
import com.yydone.demo.dal.model.ContractorNode;
import com.yydone.demo.dal.model.MobileNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MobileRepositoryTest {

    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private ContractorRepository contractorRepository;

    @Test
    public void save() {
        String contractNo = "20190200000003";
        ContractorNode contractorNode = contractorRepository.findByContractNo(contractNo);
        MobileNode mobileNode = new MobileNode();
        mobileNode.setMobileId(Long.valueOf(new SimpleDateFormat("MMddHHmmss").format(new Date())));
        mobileNode.setMobileNo("138000138002");
        mobileNode.setStatus("NORMAL");
        mobileNode.setContractorNode(contractorNode);
        MobileNode m = mobileRepository.save(mobileNode);
        log.info("ok");
    }

    @Test
    public void update() {
        MobileNode mobileNode = mobileRepository.findByMobileNo("138000138000");
        log.info("result: {}", mobileNode);
        mobileNode.setStatus("NORMAL");
        String contractNo = "20190200000001";
        ContractorNode contractorNode = contractorRepository.findByContractNo(contractNo);
        mobileNode.setContractorNode(contractorNode);
        mobileRepository.save(mobileNode);

        mobileNode = mobileRepository.findByMobileNo("138000138000");
        log.info("result: {}", mobileNode);
    }
}
