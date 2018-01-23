package com.yydone.dao;

import com.yydone.model.Trans;
import org.apache.ibatis.annotations.Param;

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
}
