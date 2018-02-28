package com.yydone.dao;

import com.yydone.model.Trans;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TransMapper {

    /**
     *
     * @param trans
     * @return
     */
    public int save(@Param("trans") Trans trans);

    /**
     *
     * @param transId
     * @param transState
     * @param version
     * @return
     */
    public int update(@Param("transId")String transId, @Param("transState")String transState, @Param("version")int version);

    /**
     *
     * @param transId
     * @return
     */
    public Trans get(String transId);

    /**
     * 获取商户的分页订单
     * @param orgCode
     * @param start
     * @return
     */
    public List<Trans> getList(@Param("orgCode") String orgCode,@Param("start") int start);

    /**
     *
     * @param orgCode
     * @return
     */
    public int getCount(@Param("orgCode") String orgCode);

    /**
     * 更新余额
     * @param transId
     * @param transAmt
     * @return
     */
    public int updateAmt(@Param("transId") String transId, @Param("transAmt")long transAmt);

    public List<Trans> getLists(@Param("transState") String  transState);
}
