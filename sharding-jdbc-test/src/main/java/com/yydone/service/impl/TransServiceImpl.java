package com.yydone.service.impl;

import com.yydone.model.Trans;
import com.yydone.service.TransService;
import org.springframework.stereotype.Service;

@Service
public class TransServiceImpl implements TransService {

    @Override
    public int save(Trans trans) {
        return 0;
    }

    @Override
    public int update(String transId, String transState) {
        return 0;
    }
}
