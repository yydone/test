package com.yydone.demo.facade;

import com.yydone.demo.facade.dto.MemberDTO;

/**
 * @author yunix
 * @since 2018/3/14
 */
public interface MemberFacade {

    public MemberDTO get(String memberId);
}
