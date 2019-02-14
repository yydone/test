package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.EmailNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EmailRepository extends Neo4jRepository<EmailNode, Long> {
}
