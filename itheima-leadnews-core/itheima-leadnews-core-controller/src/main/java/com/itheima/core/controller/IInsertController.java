package com.itheima.core.controller;


import com.itheima.common.pojo.Result;

/***
 * 描述
 * @author ljh
 * @packagename com.changgou.core.service
 * @version 1.0
 * @date 2020/8/9
 */
public interface IInsertController<T> {
    /**
     * 添加记录
     * @param record
     * @return
     */
    Result insert(T record);

}