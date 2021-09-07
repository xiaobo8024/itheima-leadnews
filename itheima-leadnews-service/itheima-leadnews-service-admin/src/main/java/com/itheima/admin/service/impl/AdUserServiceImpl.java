package com.itheima.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.admin.mapper.AdUserMapper;
import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.service.AdUserService;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.util.AppJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 管理员用户信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2021-07-30
 */
@Service
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {

    @Autowired
    private AdUserMapper adUserMapper;

    @Override
    public Map<String, Object> login(AdUser adUser) throws LeadNewsException {
        //1.判断是否为空 如果为空 提示错误
        if(StringUtils.isEmpty(adUser.getName()) || StringUtils.isEmpty(adUser.getPassword())){
            throw new LeadNewsException("用户名和密码不能为空");
        }

        //2.获取页面传递过来的用户名 根据用户名获取数据库中的记录  如果获取不到  提示错误

        //select * from ad_user where name = ?
        QueryWrapper<AdUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",adUser.getName());
        AdUser adUserFromDb = adUserMapper.selectOne(queryWrapper);
        if(adUserFromDb==null){
            throw new LeadNewsException("用户名或者密码错误");
        }

        //3.获取页面传递过来的密码（明文）+ 数据库中的盐salt 再通过 md5加密得出密文
        String passwordFromweb = adUser.getPassword()+adUserFromDb.getSalt();

        String passwordFromwebMd5 = DigestUtils.md5DigestAsHex(passwordFromweb.getBytes());

        //4.对比 从数据库中获取的密文 和 页面传递过来的密文 如果 不正确 提示错误
        if(!passwordFromwebMd5.equals(adUserFromDb.getPassword())){
            throw new LeadNewsException("用户名或者密码错误");
        }

        //5.如果正确 就生成令牌（jwt生成） 返回数据  1
        String token = AppJwtUtil.createToken(Long.valueOf(adUserFromDb.getId()));
        Map<String, Object> info = new HashMap<>();
        info.put("token",token);
        //还需要设置 用户头像 昵称 用户名 3个
        adUserFromDb.setSalt("");
        adUserFromDb.setPassword("");
        info.put("user",adUserFromDb);
        return info;
    }
}
