package com.yydone.demo.test;

import com.yydone.demo.dal.mapper.MemberMapper;
import com.yydone.demo.dal.model.MemberDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MapperScan(basePackages="com.yydone.demo.dal.mapper")
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void getTest() {
        MemberDO memberDO = memberMapper.getMemberId("111");
        System.out.println(memberDO.toString());
    }

}
