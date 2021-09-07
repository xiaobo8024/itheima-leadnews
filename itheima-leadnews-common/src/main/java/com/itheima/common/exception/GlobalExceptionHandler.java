package com.itheima.common.exception;

import com.itheima.common.pojo.Result;
import com.itheima.common.pojo.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/7/30 09:09
 * @description 标题
 * @package com.itheima.common.exception
 */
@RestControllerAdvice

public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //系统的异常处理
    @ExceptionHandler(value=Exception.class)
    public Result handleException(Exception e){
        LOGGER.error("system error:",e);
        return Result.errorMessage(e.getMessage());
    }


    //业务的异常处理
    @ExceptionHandler(value=LeadNewsException.class)
    public Result handleBussinesException(LeadNewsException e){
        LOGGER.error("leadnews error:",e);
        return Result.errorMessage(e.getMessage());
    }
}
