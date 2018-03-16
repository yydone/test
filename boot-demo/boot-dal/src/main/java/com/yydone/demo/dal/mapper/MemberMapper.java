package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.MemberDO;
import org.apache.ibatis.annotations.Param;

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
    MemberDO getMemberId(@Param("memberId") String memberId);
}
