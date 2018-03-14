package com.yydone.demo.manager.impl;

import com.yydone.demo.manager.MemberManager;
import com.yydone.demo.mapper.MemberMapper;
import com.yydone.demo.model.MemberDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yunix
 * @since 2018/3/14
 */
@Component
public class MemberManagerImpl implements MemberManager {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberDO get(String memberId) {
        return memberMapper.get(memberId);
    }
}
