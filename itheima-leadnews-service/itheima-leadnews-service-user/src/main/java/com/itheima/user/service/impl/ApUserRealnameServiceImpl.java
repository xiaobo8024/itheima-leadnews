package com.itheima.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.common.constants.BusinessConstants;
import com.itheima.media.pojo.WmUser;
import com.itheima.user.feign.ApAuthorFeign;
import com.itheima.user.feign.WmUserFeign;
import com.itheima.user.mapper.ApUserMapper;
import com.itheima.user.mapper.ApUserRealnameMapper;
import com.itheima.user.pojo.ApUserRealname;
import com.itheima.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * APP实名认证信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {

    @Autowired
    private ApUserRealnameMapper apUserRealnameMapper;

    @Autowired
    private WmUserFeign wmUserFeign;

    @Autowired
    private ApUserMapper apUserMapper;


    @Autowired
    private ApAuthorFeign apAuthorFeign;


    @Override
    public void pass(Integer id) {



    }

    @Override
    public void reject(Integer id, String reason) {

        //通过审核改变审核状态
        ApUserRealname entity=new ApUserRealname();
        entity.setStatus(BusinessConstants.ApUserRealnameConstants.MEDIA_STATUS_SUCCESS);
        entity.setId(id);
        apUserRealnameMapper.updateById(entity);

        //查询这个用户是否存在多媒体账户
        Integer apUserId = wmUserFeign.getByApUserId(id).getApUserId();


    }
}
