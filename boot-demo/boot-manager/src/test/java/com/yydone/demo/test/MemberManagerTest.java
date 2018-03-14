package com.yydone.demo.test;

import com.yydone.demo.manager.impl.MemberManagerImpl;
import com.yydone.demo.mapper.MemberMapper;
import com.yydone.demo.model.MemberDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberManagerTest {

    @InjectMocks
    private MemberManagerImpl memberManager;
    @Mock
    private MemberMapper memberMapper;

    @Test
    public void getTest() {
        MemberDO m = new MemberDO();
        m.setMemberId("1");
        when(memberMapper.get(Mockito.anyString())).thenReturn(m);
        Assert.assertEquals("1", memberManager.get("1").getMemberId());
    }
}
