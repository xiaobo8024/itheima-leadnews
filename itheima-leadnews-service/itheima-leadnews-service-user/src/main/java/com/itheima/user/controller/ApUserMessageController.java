package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserMessage;
import com.itheima.user.service.ApUserMessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户消息通知信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户消息通知信息表",tags = "ApUserMessageController")
@RestController
@RequestMapping("/apUserMessage")
public class ApUserMessageController extends AbstractCoreController<ApUserMessage> {

    private ApUserMessageService apUserMessageService;

    //注入
    @Autowired
    public ApUserMessageController(ApUserMessageService apUserMessageService) {
        super(apUserMessageService);
        this.apUserMessageService=apUserMessageService;
    }

}

