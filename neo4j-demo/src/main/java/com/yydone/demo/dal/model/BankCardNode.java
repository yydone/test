package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

@Setter
@Getter
@ToString
@NodeEntity(label = "BankCardNode")
public class BankCardNode {

    @Id
    @GeneratedValue
    private Long nodeId;
    @Index(unique = true)
    @Property(name = "bank_card_no")
    private String bankCardNo;
    @Property(name = "bank_code")
    private String bankCode;
    @Property(name = "bank_card_mobile")
    private String bankCardMobile;
}
