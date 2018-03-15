package com.yydone.demo.controller;

import com.yydone.demo.facade.MemberFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunix
 * @since 2018/3/14
 */
@RequestMapping("mem")
@RestController
public class MemberController {

    @Autowired
    private MemberFacade memberFacade;

    @RequestMapping("get")
    @ResponseBody
    public String get() {
        return memberFacade.get("111").toString();
    }

    @RequestMapping("update")
    public String update() {
        return "this is update method";
    }
}
