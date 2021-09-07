package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserFeedback;
import com.itheima.user.service.ApUserFeedbackService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户反馈信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户反馈信息表",tags = "ApUserFeedbackController")
@RestController
@RequestMapping("/apUserFeedback")
public class ApUserFeedbackController extends AbstractCoreController<ApUserFeedback> {

    private ApUserFeedbackService apUserFeedbackService;

    //注入
    @Autowired
    public ApUserFeedbackController(ApUserFeedbackService apUserFeedbackService) {
        super(apUserFeedbackService);
        this.apUserFeedbackService=apUserFeedbackService;
    }

}

