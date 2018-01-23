package com.yydone.service;

import com.yydone.model.Trans;

public interface TransService {

    public int save(Trans trans);

    public int update(String transId, String transState);
}
