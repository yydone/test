package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.MobileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MobileRepository extends Neo4jRepository<MobileNode, Long> {

    MobileNode findByMobileNo(String mobileNo);


}
