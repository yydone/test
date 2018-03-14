package com.yydone.demo.mapper;

import com.yydone.demo.model.MemberDO;

/**
 * @author yunix
 * @since 2018/2/14
 */
public interface MemberMapper {

    /**
     * 根据商户号获取商户信息
     * @param memberId
     * @return
     */
    MemberDO get(String memberId);
}
