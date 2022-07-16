package com.example.seckillsystemdemo.rabbitmq;

import com.example.seckillsystemdemo.constants.RespBeanEnum;
import com.example.seckillsystemdemo.entity.SeckillMessage;
import com.example.seckillsystemdemo.entity.SeckillOrder;
import com.example.seckillsystemdemo.entity.User;
import com.example.seckillsystemdemo.service.IGoodsService;
import com.example.seckillsystemdemo.service.IOrderService;
import com.example.seckillsystemdemo.utils.JsonUtil;
import com.example.seckillsystemdemo.vo.GoodsVo;
import com.example.seckillsystemdemo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 *
 * @Author Administrator
 * @Date 2022/7/14 16:48
 */
@Service
@Slf4j
public class MQReceiver {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IOrderService orderService;

    /**
     * 下单操作，实现流量削峰
     *
     * @param msg
     */
    @RabbitListener(queues = "seckillQueue")
    public void receive(String msg) {
        log.info("接收到的消息 {}", msg);
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(msg, SeckillMessage.class);
        Long goodsId = seckillMessage.getGoodsId();
        User user = seckillMessage.getUser();
        //判断库存
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        if (goodsVo.getStockCount() < 0) {
            return;
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder =
                (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if (seckillOrder != null) {
            return;
        }
        //下单操作
        orderService.seckill(user, goodsVo);
    }

//    @RabbitListener(queues = "queue")
//    public void receive(Object msg) {
//        log.info("接收消息 {}", msg);
//    }
//    @RabbitListener(queues = "queue_fanout01")
//    public void receiveFanout01(Object msg) {
//        log.info("Fanout01接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_fanout02")
//    public void receiveFanout02(Object msg) {
//        log.info("Fanout02接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_direct01")
//    public void receiveDirect01(Object msg) {
//        log.info("Direct01接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_direct02")
//    public void receiveDirect02(Object msg) {
//        log.info("Direct02接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_topic01")
//    public void receiveTopic01(Object msg) {
//        log.info("TopicQUEUE01接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_topic02")
//    public void receiveTopic02(Object msg) {
//        log.info("TopicQUEUE02接收消息" + msg);
//    }
//
//    @RabbitListener(queues = "queue_header01")
//    public void receiveHeaders01(Message message) {
//        log.info("headersQUEUE01接收消息 message对象 " + message);
//        log.info("headersQUEUE01接收消息" + new String(message.getBody()));
//    }
//
//    @RabbitListener(queues = "queue_header02")
//    public void receiveHeaders02(Message message) {
//        log.info("headersQUEUE02接收消息 message对象" + message);
//        log.info("headersQUEUE02接收消息" + new String(message.getBody()));
//    }
}
