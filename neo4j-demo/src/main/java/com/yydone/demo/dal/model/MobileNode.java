package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Setter
@Getter
@ToString
@NodeEntity
public class MobileNode {

    @Id
    @GeneratedValue
    private Long nodeId;
    @Property(name = "mobileId")
    private Long mobileId;
    @Property(name = "mobile_no")
    private String mobileNo;
    @Property(name = "status")
    private String status;

    @Relationship(type = "MOBILE", direction = Relationship.INCOMING)
    private ContractorNode contractorNode;
}
