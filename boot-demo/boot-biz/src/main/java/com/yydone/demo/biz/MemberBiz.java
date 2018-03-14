package com.yydone.demo.biz;

import com.yydone.demo.facade.dto.MemberDTO;

public interface MemberBiz {

    public MemberDTO get(String memberId);
}
