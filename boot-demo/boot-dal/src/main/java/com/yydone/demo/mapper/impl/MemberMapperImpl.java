package com.yydone.demo.mapper.impl;

import com.yydone.demo.mapper.MemberMapper;
import com.yydone.demo.model.MemberDO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDO get(String memberId) {

        MemberDO memberDO = new MemberDO();
        memberDO.setMemberId("1");
        memberDO.setMemberName("测试");
        return memberDO;
    }
}
