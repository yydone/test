package com.yydone.demo.service;

import com.yydone.demo.biz.MemberBiz;
import com.yydone.demo.facade.MemberFacade;
import com.yydone.demo.facade.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunix
 * @since 2018/3/14
 */
@Service
public class MemberService implements MemberFacade {

    @Autowired
    private MemberBiz memberBiz;

    @Override
    public MemberDTO get(String memberId) {

        return memberBiz.get(memberId);
    }
}
