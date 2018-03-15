package com.yydone.demo.manager;

import com.yydone.demo.dal.model.MemberDO;

/**
 * @author yunix
 * @since 2018/3/14
 */
public interface MemberManager {

    /**
     * 根据商户号获取商户信息
     * @param memberId
     * @return
     */
    MemberDO get(String memberId);
}
