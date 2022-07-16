package com.example.seckillsystemdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckillsystemdemo.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
