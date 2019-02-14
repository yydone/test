package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.ContractorNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ContractorRepository extends Neo4jRepository<ContractorNode, Long> {

    ContractorNode findByContractNo(String contractNo);

    @Query(value = "MATCH p=(m:ContractorNode)-[r:MOBILE]->(n:MobileNode{mobile_no:'13918744763'}) RETURN m",
            countQuery = "MATCH p=(m:ContractorNode)-[r:MOBILE]->(n:MobileNode{mobile_no:'13918744763'}) RETURN count(m)")
    Page<ContractorNode> findByMobileNo(String mobileNo, Pageable pageable);
}
