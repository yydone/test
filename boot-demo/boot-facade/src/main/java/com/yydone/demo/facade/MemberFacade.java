package com.yydone.demo.facade;

import com.yydone.demo.facade.dto.MemberDTO;

/**
 * @author yunix
 * @since 2018/3/14
 */
public interface MemberFacade {

    /**
     * 根据商户号获取商户信息
     * @param memberId
     * @return
     */
    MemberDTO get(String memberId);
}
