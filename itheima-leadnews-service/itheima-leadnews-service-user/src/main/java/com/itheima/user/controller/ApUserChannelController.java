package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserChannel;
import com.itheima.user.service.ApUserChannelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户频道信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户频道信息表",tags = "ApUserChannelController")
@RestController
@RequestMapping("/apUserChannel")
public class ApUserChannelController extends AbstractCoreController<ApUserChannel> {

    private ApUserChannelService apUserChannelService;

    //注入
    @Autowired
    public ApUserChannelController(ApUserChannelService apUserChannelService) {
        super(apUserChannelService);
        this.apUserChannelService=apUserChannelService;
    }

}

