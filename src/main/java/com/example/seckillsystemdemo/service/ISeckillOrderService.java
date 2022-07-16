package com.example.seckillsystemdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckillsystemdemo.entity.SeckillOrder;
import com.example.seckillsystemdemo.entity.User;

/**
 * <p>
 * 秒杀订单表 服务接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
public interface ISeckillOrderService extends IService<SeckillOrder> {

    /**
     * 获取秒杀结果
     *
     * @param user
     * @param goodsId
     * @return orderId：成功， -1：秒杀失败， 0：排队中
     */
    Long getResult(User user, Long goodsId);
}
