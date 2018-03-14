package com.yydone.demo.facade.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yunix
 * @since 2018/3/14
 */
@Setter
@Getter
@ToString
public class MemberDTO implements Serializable {

    private String memberId;
    private String memberName;
    private Date createTime;
    private Date updateTime;
}
