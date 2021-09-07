package com.itheima.user.feign;

import com.itheima.core.feign.CoreFeign;
import com.itheima.media.pojo.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "leadnews-wemedia",value = "/wmUser")
public interface WmUserFeign extends CoreFeign<WmUser> {
    @GetMapping("/one/{id}")
    public WmUser getByApUserId(@PathVariable(name = "id") Integer id);
}
