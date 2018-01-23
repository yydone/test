package com.yydone.dao.test;

import com.yydone.dao.TransMapper;
import com.yydone.model.Trans;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TransMapperTest {

    @Autowired
    private TransMapper transMapper;

    @Test
    public void saveTest() {
        Trans trans = new Trans();
        trans.setTransId("2018012315300012345678901234123");
        trans.setOrgCode("Z1020020020001");
        trans.setTransAmt(100L);
        trans.setTransState("00");
        transMapper.save(trans);
    }

    @Test
    public void getTest() {
        String transId = "2018012315300012345678901234123";
        Trans trans = transMapper.get(transId);
        Assert.assertTrue(trans.getTransState().equals("00"));
    }

    @Test
    public void updateTest() {
        String transId = "2018012315300012345678901234123";
        transMapper.update(transId, "22", 2);
        Trans trans = transMapper.get(transId);
        Assert.assertTrue(trans.getTransState().equals("22"));
    }

}
