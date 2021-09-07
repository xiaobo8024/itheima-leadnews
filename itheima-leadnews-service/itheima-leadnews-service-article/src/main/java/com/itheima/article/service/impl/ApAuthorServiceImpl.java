package com.itheima.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.article.mapper.ApAuthorMapper;
import com.itheima.article.pojo.ApAuthor;
import com.itheima.article.service.ApAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP文章作者信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
@Service
public class ApAuthorServiceImpl extends ServiceImpl<ApAuthorMapper, ApAuthor> implements ApAuthorService {

    @Autowired
    private ApAuthorMapper apAuthorMapper;

    @Override
    public ApAuthor getAuthByMediaId(Integer id){
        QueryWrapper<ApAuthor> query=new QueryWrapper<>();
        query.eq("author_id",id);
        ApAuthor apAuthor = apAuthorMapper.selectOne(query);
        return apAuthor;
    }
}
