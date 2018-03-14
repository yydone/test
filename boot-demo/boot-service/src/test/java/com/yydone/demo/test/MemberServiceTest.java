package com.yydone.demo.test;

import com.yydone.demo.biz.MemberBiz;
import com.yydone.demo.facade.dto.MemberDTO;
import com.yydone.demo.service.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberBiz memberBiz;

    @Test
    public void getTest() {
        MemberDTO dto = new MemberDTO();
        dto.setMemberId("1");
        when(memberBiz.get(Mockito.anyString())).thenReturn(dto);
        Assert.assertEquals("1", memberService.get("1").getMemberId());
    }
}
