package com.yydone.demo.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author yunix
 * @since 2018/3/14
 */
@Setter
@Getter
@ToString
public class MemberDO {

    private String memberId;

    private String memberName;

    private Date createTime;

    private Date updateTime;

    private Integer version;
}
