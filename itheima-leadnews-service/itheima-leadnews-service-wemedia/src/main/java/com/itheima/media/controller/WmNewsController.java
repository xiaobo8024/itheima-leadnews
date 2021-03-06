package com.itheima.media.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.media.pojo.WmNews;
import com.itheima.media.service.WmNewsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 自媒体图文内容信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="自媒体图文内容信息表",tags = "WmNewsController")
@RestController
@RequestMapping("/wmNews")
public class WmNewsController extends AbstractCoreController<WmNews> {

    private WmNewsService wmNewsService;

    //注入
    @Autowired
    public WmNewsController(WmNewsService wmNewsService) {
        super(wmNewsService);
        this.wmNewsService=wmNewsService;
    }

}

