package com.yydone.demo.test;

import com.yydone.demo.biz.impl.MemberBizImpl;
import com.yydone.demo.facade.dto.MemberDTO;
import com.yydone.demo.manager.MemberManager;
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
public class MemberBizTest {

    @InjectMocks
    private MemberBizImpl memberBiz;
    @Mock
    private MemberManager memberManager;

    @Test
    public void getTest() {
        MemberDO dto = new MemberDO();
        dto.setMemberId("1");
        when(memberManager.get(Mockito.anyString())).thenReturn(dto);
        Assert.assertEquals("1", memberBiz.get("1").getMemberId());
    }
}
