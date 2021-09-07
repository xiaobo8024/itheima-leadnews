package com.itheima.user.controller;


import com.itheima.common.pojo.Result;
import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserRealname;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP实名认证信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP实名认证信息表",tags = "ApUserRealnameController")
@RestController
@RequestMapping("/apUserRealname")
public class ApUserRealnameController extends AbstractCoreController<ApUserRealname> {

    private ApUserRealnameService apUserRealnameService;

    //注入
    @Autowired
    public ApUserRealnameController(ApUserRealnameService apUserRealnameService) {
        super(apUserRealnameService);
        this.apUserRealnameService=apUserRealnameService;
    }


    @PutMapping("/pass/{id}")
    public Result pass(@PathVariable(name = "id") Integer id){
        apUserRealnameService.pass(id);
        return Result.ok();
    }

    @PutMapping("/refuse/{id}")
    public Result refuse(@PathVariable(name = "id") Integer id,String reason){
        apUserRealnameService.refuse(id,reason);
        return Result.ok();
    }
}

