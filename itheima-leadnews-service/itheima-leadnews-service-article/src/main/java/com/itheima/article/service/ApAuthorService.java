package com.itheima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.article.pojo.ApAuthor;

/**
 * <p>
 * APP文章作者信息表 服务类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
public interface ApAuthorService extends IService<ApAuthor> {
    ApAuthor getAuthByMediaId(Integer id);
}
