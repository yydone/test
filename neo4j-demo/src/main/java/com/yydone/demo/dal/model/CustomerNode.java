package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Setter
@Getter
@ToString
@NodeEntity
public class CustomerNode {

    @Id
    @GeneratedValue
    private Long nodeId;
    @Property(name = "customer_no")
    private String customerNo;
    @Property(name = "customer_name")
    private String customerName;
    @Property(name = "id_number")
    private String idNumber;
    @Property(name = "sex")
    private String sex;
}
