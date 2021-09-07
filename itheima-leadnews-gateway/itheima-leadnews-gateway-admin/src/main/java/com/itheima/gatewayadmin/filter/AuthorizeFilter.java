package com.itheima.gatewayadmin.filter;

import com.itheima.common.constants.SystemConstants;
import com.itheima.common.util.AppJwtUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/8/1 09:06
 * @description 标题
 * @package com.itheima.gatewayadmin.filter
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //+ 1.先获取请求和响应对象
        ServerHttpRequest request = exchange.getRequest();

        ServerHttpResponse response = exchange.getResponse();
        // /get /a  post /a

        //+ 2.判断当前的请求 是否 是登录的请求 如果是 ，则放行
        String path = request.getURI().getPath();
        if(path.startsWith("/admin/admin/login") || path.endsWith("/v2/api-docs")){
            return chain.filter(exchange);
        }

        //+ 3.获取页面传递过来的请求头中的令牌数据 如果获取不到 返回错误（401）
        String token = request.getHeaders().getFirst("token");
        if(StringUtils.isEmpty(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return  response.setComplete();//完成响应 返回 后面就不执行了
        }

        //+ 4.校验令牌 校验失败 返回错误401
        //通过jwt 来校验
        if(SystemConstants.JWT_OK!=AppJwtUtil.verifyToken(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return  response.setComplete();//完成响应 返回 后面就不执行了
        }
        //+ 5.校验成功 放行
        return chain.filter(exchange);
    }


    //过滤器的执行的优先级的设置 值越低 优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
