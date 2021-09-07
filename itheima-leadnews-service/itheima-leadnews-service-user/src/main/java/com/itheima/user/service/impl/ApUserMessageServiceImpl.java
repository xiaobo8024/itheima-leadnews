package com.itheima.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.user.mapper.ApUserMessageMapper;
import com.itheima.user.pojo.ApUserMessage;
import com.itheima.user.service.ApUserMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP用户消息通知信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2021-08-01
 */
@Service
public class ApUserMessageServiceImpl extends ServiceImpl<ApUserMessageMapper, ApUserMessage> implements ApUserMessageService {

}
