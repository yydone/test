package com.yydone.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Trans {

    private String transId;
    private String orgCode;
    private Long transAmt;
    private String transState;
    private Date createTime;
    private Date updateTime;
    private Integer version;

}
