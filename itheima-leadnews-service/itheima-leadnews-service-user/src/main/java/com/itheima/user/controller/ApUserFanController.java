package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserFan;
import com.itheima.user.service.ApUserFanService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户粉丝信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户粉丝信息表",tags = "ApUserFanController")
@RestController
@RequestMapping("/apUserFan")
public class ApUserFanController extends AbstractCoreController<ApUserFan> {

    private ApUserFanService apUserFanService;

    //注入
    @Autowired
    public ApUserFanController(ApUserFanService apUserFanService) {
        super(apUserFanService);
        this.apUserFanService=apUserFanService;
    }

}

