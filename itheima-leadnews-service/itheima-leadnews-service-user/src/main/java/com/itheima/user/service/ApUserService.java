package com.itheima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.user.pojo.ApUser;

import java.util.Map;

/**
 * <p>
 * APP用户信息表 服务类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
public interface ApUserService extends IService<ApUser> {

     Map<String, Object> login(ApUser apUser) throws LeadNewsException;
}
