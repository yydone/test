package com.yydone.demo.test.mapper;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.ContractorRepository;
import com.yydone.demo.dal.mapper.CustomerRepository;
import com.yydone.demo.dal.model.ContractorNode;
import com.yydone.demo.dal.model.CustomerNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ContractorRepositoryTest {

    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void save() {
        ContractorNode contractorNode = new ContractorNode();
        contractorNode.setContractNo("20190200000003");
        contractorNode.setContractName("将将");
        contractorNode.setLinkEmail("yunix03@yydone.com");
        contractorNode.setLinkMobile("13800138003");
        CustomerNode customerNode = customerRepository.findByCustomerNo("2019010001");
        contractorNode.setCustomerNode(customerNode);
        contractorRepository.save(contractorNode);
    }

    @Test
    public void update() {
        ContractorNode contractorNode = contractorRepository.findByContractNo("20190200000002");
        CustomerNode customerNode = customerRepository.findByCustomerNo("2019010001");
        contractorNode.setCustomerNode(customerNode);
        contractorNode.setCustomerNode(customerNode);
        contractorRepository.save(contractorNode);
    }

    @Test
    public void findByMobileNo() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by(Sort.Order.asc("m.contract_no")));
        Page<ContractorNode> result = contractorRepository.findByMobileNo("13800138000", pageable);
        log.info("result:{}", result);
    }

    @Test
    public void findByContractNo() {
        ContractorNode contractorNode = contractorRepository.findByContractNo("20190200000003");
        log.info(contractorNode.toString());
    }
}
