package com.example.seckillsystemdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckillsystemdemo.entity.Order;
import com.example.seckillsystemdemo.entity.User;
import com.example.seckillsystemdemo.vo.GoodsVo;
import com.example.seckillsystemdemo.vo.OrderDetailVo;

/**
 * <p>
 * 订单表 服务接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
public interface IOrderService extends IService<Order> {

    /**
     * 秒杀
     *
     * @param user
     * @param goodsVo
     * @return
     */
    Order seckill(User user, GoodsVo goodsVo);

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailVo detail(Long orderId);

    /**
     * 获取秒杀地址
     * 不同的用户拿到的地址是不一样的
     *
     * @param user
     * @param goodsId
     * @return
     */
    String createPath(User user, Long goodsId);

    /**
     * 校验秒杀地址
     * 因为不用的用户的地址是不一样的，需要校验当前获取的地址是否为当前用户的
     *
     * @param user
     * @param goodsId
     * @param path
     * @return
     */
    boolean checkPath(User user, Long goodsId, String path);

    /**
     * 校验验证码
     *
     * @param user
     * @param goodsId
     * @param captcha
     * @return
     */
    boolean checkCaptcha(User user, Long goodsId, String captcha);
}
