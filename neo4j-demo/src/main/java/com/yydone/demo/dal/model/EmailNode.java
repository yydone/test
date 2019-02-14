package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Setter
@Getter
@ToString
@NodeEntity(label = "EmailNode")
public class EmailNode {

    @Id
    @GeneratedValue
    private Long nodeId;
    @Index(unique = true)
    @Property(name = "email")
    private String email;
}
