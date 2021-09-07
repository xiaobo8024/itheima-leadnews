package com.itheima.admin.controller;

import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.service.AdUserService;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/7/30 14:39
 * @description 标题
 * @package com.itheima.admin.controller
 */
@RequestMapping("/admin")
@RestController
public class LoginController {

    @Autowired
    private AdUserService adUserService;


    //接收用户名和密码
    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody AdUser adUser) throws LeadNewsException {
        Map<String,Object> map = adUserService.login(adUser);
        return Result.ok(map);
    }

    public static void main(String[] args) {
        String pass = "1234567"+"abc";
        String s = DigestUtils.md5DigestAsHex(pass.getBytes());
        System.out.println(s);
    }
}
