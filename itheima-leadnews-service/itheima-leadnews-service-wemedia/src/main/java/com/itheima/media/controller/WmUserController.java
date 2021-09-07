package com.itheima.media.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.itheima.common.pojo.Result;
import com.itheima.core.controller.AbstractCoreController;
import com.itheima.media.pojo.WmUser;
import com.itheima.media.service.WmUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* <p>
* 自媒体用户信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="自媒体用户信息表",tags = "WmUserController")
@RestController
@RequestMapping("/wmUser")
public class WmUserController extends AbstractCoreController<WmUser> {

    private WmUserService wmUserService;

    //注入
    @Autowired
    public WmUserController(WmUserService wmUserService) {
        super(wmUserService);
        this.wmUserService=wmUserService;
    }

    @GetMapping("/one/{id}")
    public WmUser getByApUserId(@PathVariable(name = "id") Integer id){

        QueryWrapper<WmUser> query=new QueryWrapper<>();
        query.eq("ap_user_id",id);

        return wmUserService.getOne(query);
    }
}

