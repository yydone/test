package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.BankCardNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BankCardRepository extends Neo4jRepository<BankCardNode, Long> {

    BankCardNode findByBankCardNo(String bankCardNo);
}
