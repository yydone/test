package com.yydone.demo.test;

import com.yydone.demo.mapper.impl.MemberMapperImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberMapperTest {

    @InjectMocks
    private MemberMapperImpl memberMapper;

    @Test
    public void getTest() {
        Assert.assertEquals("1", memberMapper.get("1").getMemberId());
    }

}
