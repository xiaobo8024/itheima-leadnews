package com.itheima.user.controller;


import com.itheima.core.controller.AbstractCoreController;
import com.itheima.user.pojo.ApUserEquipment;
import com.itheima.user.service.ApUserEquipmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* APP用户设备信息表 控制器</p>
* @author ljh
* @since 2021-08-01
*/
@Api(value="APP用户设备信息表",tags = "ApUserEquipmentController")
@RestController
@RequestMapping("/apUserEquipment")
public class ApUserEquipmentController extends AbstractCoreController<ApUserEquipment> {

    private ApUserEquipmentService apUserEquipmentService;

    //注入
    @Autowired
    public ApUserEquipmentController(ApUserEquipmentService apUserEquipmentService) {
        super(apUserEquipmentService);
        this.apUserEquipmentService=apUserEquipmentService;
    }

}

