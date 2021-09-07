package com.itheima.user.feign;

import com.itheima.article.pojo.ApAuthor;
import com.itheima.core.feign.CoreFeign;
import com.itheima.media.pojo.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "leadnews-article",value = "/")
public interface ApAuthorFeign extends CoreFeign<ApAuthor> {


}
