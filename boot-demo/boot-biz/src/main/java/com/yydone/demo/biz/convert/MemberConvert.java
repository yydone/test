package com.yydone.demo.biz.convert;

import com.yydone.demo.facade.dto.MemberDTO;
import com.yydone.demo.dal.model.MemberDO;
import org.springframework.util.ObjectUtils;

/**
 * @author yunix
 * @since 2018/3/14
 */
public class MemberConvert {

    private MemberConvert() {}

    public static MemberDTO convert(MemberDO m) {
        if(ObjectUtils.isEmpty(m)) {
            return null;
        }
        MemberDTO dto = new MemberDTO();
        dto.setMemberId(m.getMemberId());
        dto.setMemberName(m.getMemberName());
        dto.setCreateTime(m.getCreateTime());
        dto.setUpdateTime(m.getUpdateTime());
        return dto;
    }
}
