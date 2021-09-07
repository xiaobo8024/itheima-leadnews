package com.itheima.user.controller;

import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.pojo.Result;

import com.itheima.user.pojo.ApUser;
import com.itheima.user.service.ApUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class LoginController {
    @Autowired
    private ApUserService apUserService;


    //接收用户名和密码
    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody ApUser apUser) throws LeadNewsException {
        Map<String,Object> map = apUserService.login(apUser);
        return Result.ok(map);
    }

    public static void main(String[] args) {
        String pass = "1234567"+"abc";
        String s = DigestUtils.md5DigestAsHex(pass.getBytes());
        System.out.println(s);
    }
}