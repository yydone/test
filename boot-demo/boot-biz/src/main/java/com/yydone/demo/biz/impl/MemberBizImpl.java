package com.yydone.demo.biz.impl;

import com.yydone.demo.biz.MemberBiz;
import com.yydone.demo.biz.convert.MemberConvert;
import com.yydone.demo.facade.dto.MemberDTO;
import com.yydone.demo.manager.MemberManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yunix
 * @since 2018/3/14
 */
@Component
public class MemberBizImpl implements MemberBiz {

    @Autowired
    private MemberManager memberManager;

    @Override
    public MemberDTO get(String memberId) {
        return MemberConvert.convert(memberManager.get(memberId));
    }
}
