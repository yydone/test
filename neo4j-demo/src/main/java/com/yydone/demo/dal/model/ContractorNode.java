package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Setter
@Getter
@ToString
@NodeEntity
public class ContractorNode {

    @Id
    @GeneratedValue
    private Long nodeId;
    @Property(name = "contract_no")
    private String contractNo;
    @Property(name = "contract_name")
    private String contractName;
    @Property(name = "link_mobile")
    private String linkMobile;
    @Property(name = "link_email")
    private String linkEmail;

    @Relationship(type="CONTAIN_OF", direction = Relationship.INCOMING)
    private CustomerNode customerNode;
}
