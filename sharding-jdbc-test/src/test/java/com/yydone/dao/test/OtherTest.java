package com.yydone.dao.test;

import org.junit.Test;

public class OtherTest {

    @Test
    public void StringSubTest() {
        String str = "201801241108001123201702";
        System.out.println(str.substring(str.length()-2, str.length()));
    }
}
