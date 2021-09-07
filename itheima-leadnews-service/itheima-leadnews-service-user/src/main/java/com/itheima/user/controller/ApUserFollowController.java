package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserFollow;
import com.itheima.user.service.ApUserFollowService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户关注信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户关注信息表",tags = "ApUserFollowController")
@RestController
@RequestMapping("/apUserFollow")
public class ApUserFollowController extends AbstractCoreController<ApUserFollow> {

    private ApUserFollowService apUserFollowService;

    //注入
    @Autowired
    public ApUserFollowController(ApUserFollowService apUserFollowService) {
        super(apUserFollowService);
        this.apUserFollowService=apUserFollowService;
    }

}

