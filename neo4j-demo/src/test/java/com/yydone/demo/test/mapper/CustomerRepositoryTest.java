package com.yydone.demo.test.mapper;

import com.yydone.demo.Application;
import com.yydone.demo.dal.mapper.CustomerRepository;
import com.yydone.demo.dal.model.CustomerNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByCustomerNo() {
        String idNumber = "320501198111177572";
        CustomerNode customerNode = customerRepository.findByIdNumber(idNumber);
        log.info("result: {}", customerNode);
    }

    @Test
    public void deleteByCustomerNo() {
        CustomerNode customerNode = customerRepository.findByIdNumber("330501198710901");
        customerRepository.delete(customerNode);
    }

    @Test
    public void save(){
        String customerNo = "2019010001";
        String customerName = "杨将军";
        String sex = "M";
        String idNumber = "320501198111177571";
        CustomerNode customerNode = new CustomerNode();
        customerNode.setCustomerNo(customerNo);
        customerNode.setCustomerName(customerName);
        customerNode.setIdNumber(idNumber);
        customerNode.setSex(sex);
        customerRepository.save(customerNode);
    }
}
