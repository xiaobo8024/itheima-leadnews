package com.itheima.media.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.media.pojo.WmFansPortrait;
import com.itheima.media.service.WmFansPortraitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 自媒体粉丝画像信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="自媒体粉丝画像信息表",tags = "WmFansPortraitController")
@RestController
@RequestMapping("/wmFansPortrait")
public class WmFansPortraitController extends AbstractCoreController<WmFansPortrait> {

    private WmFansPortraitService wmFansPortraitService;

    //注入
    @Autowired
    public WmFansPortraitController(WmFansPortraitService wmFansPortraitService) {
        super(wmFansPortraitService);
        this.wmFansPortraitService=wmFansPortraitService;
    }

}

