package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserLetter;
import com.itheima.user.service.ApUserLetterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户私信信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户私信信息表",tags = "ApUserLetterController")
@RestController
@RequestMapping("/apUserLetter")
public class ApUserLetterController extends AbstractCoreController<ApUserLetter> {

    private ApUserLetterService apUserLetterService;

    //注入
    @Autowired
    public ApUserLetterController(ApUserLetterService apUserLetterService) {
        super(apUserLetterService);
        this.apUserLetterService=apUserLetterService;
    }

}

