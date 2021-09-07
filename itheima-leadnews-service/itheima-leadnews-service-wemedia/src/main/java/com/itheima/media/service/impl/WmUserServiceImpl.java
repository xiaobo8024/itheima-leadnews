package com.itheima.media.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.media.mapper.WmUserMapper;
import com.itheima.media.pojo.WmUser;
import com.itheima.media.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 自媒体用户信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {

}
