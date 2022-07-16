package com.example.seckillsystemdemo.vo;

import com.example.seckillsystemdemo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情返回对象
 *
 * @Author Administrator
 * @Date 2022/7/14 14:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVo {

    private Order order;

    private GoodsVo goodsVo;
}
