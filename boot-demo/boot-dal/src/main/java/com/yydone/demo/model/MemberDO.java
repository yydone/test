package com.yydone.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class MemberDO {

    private String memberId;

    private String memberName;

    private Date createTime;

    private Date updateTime;

    private int version;
}
