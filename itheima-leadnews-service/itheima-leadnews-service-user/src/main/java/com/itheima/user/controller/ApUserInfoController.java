package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserInfo;
import com.itheima.user.service.ApUserInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户信息表",tags = "ApUserInfoController")
@RestController
@RequestMapping("/apUserInfo")
public class ApUserInfoController extends AbstractCoreController<ApUserInfo> {

    private ApUserInfoService apUserInfoService;

    //注入
    @Autowired
    public ApUserInfoController(ApUserInfoService apUserInfoService) {
        super(apUserInfoService);
        this.apUserInfoService=apUserInfoService;
    }

}

