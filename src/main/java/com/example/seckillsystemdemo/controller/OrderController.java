package com.example.seckillsystemdemo.controller;


import com.example.seckillsystemdemo.constants.RespBeanEnum;
import com.example.seckillsystemdemo.entity.User;
import com.example.seckillsystemdemo.service.IOrderService;
import com.example.seckillsystemdemo.vo.OrderDetailVo;
import com.example.seckillsystemdemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 订单详情
     *
     * @param user
     * @param orderId
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public RespBean detail(User user, Long orderId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        OrderDetailVo orderDetailVo = orderService.detail(orderId);
        return RespBean.success(orderDetailVo);
    }
}
