package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.CustomerNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRepository extends Neo4jRepository<CustomerNode, Long> {

    CustomerNode findByIdNumber(String idNumber);

    CustomerNode findByCustomerNo(String customerNo);
}
