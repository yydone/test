package com.yydone.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunix
 * @since 2018/3/14
 */
@RequestMapping("mem")
@RestController
public class MemberController {

    @RequestMapping("get")
    public String get() {
        return "this is get method";
    }

    @RequestMapping("update")
    public String update() {
        return "this is update method";
    }
}
