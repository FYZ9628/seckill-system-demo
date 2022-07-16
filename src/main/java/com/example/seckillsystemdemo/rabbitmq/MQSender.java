package com.example.seckillsystemdemo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息发送者
 *
 * @Author Administrator
 * @Date 2022/7/14 16:47
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送秒杀信息
     *
     * @param message
     */
    public void sendSeckillMessage(String message) {
        log.info("发送消息：{}", message);
        rabbitTemplate.convertAndSend("seckillExchange", "seckill.message", message);
    }



//    public void send(Object msg) {
//        log.info("发送消息：{}", msg);
//        rabbitTemplate.convertAndSend("queue", msg);
//    }
//
//    public void sendFanout(Object msg) {
//        log.info("发送消息：" + msg);
//        //不设置 routingKey 表明这是 fanout 模式
//        rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
//    }
//
//
//    public void sendDirectExchange01(Object msg) {
//        log.info("发送directExchange.red" + msg);
//        rabbitTemplate.convertAndSend("directExchange", "queue.red", msg);
//    }
//
//    public void sendDirectExchange02(Object msg) {
//        log.info("发送directExchange.green" + msg);
//        rabbitTemplate.convertAndSend("directExchange", "queue.green", msg);
//    }
//
//
//    public void sendTopicExchange01(Object msg) {
//        log.info("发送消息(TopicQueue01接收)：" + msg);
//        rabbitTemplate.convertAndSend("topicExchange", "queue.red.message", msg);
//    }
//
//
//    public void sendTopicExchange02(Object msg) {
//        log.info("发送消息(两个TopicQueue接收)：" + msg);
//        rabbitTemplate.convertAndSend("topicExchange", "green.queue.green.message", msg);
//    }
//
//
//    public void sendHeadersExchange01(String msg) {
//        log.info("发送消息(headersQUEUE01和headersQUEUE02接收)：" + msg);
//        MessageProperties properties = new MessageProperties();
//        properties.setHeader("color", "red");
//        properties.setHeader("speed", "fast");
//        Message message = new Message(msg.getBytes(), properties);
//        rabbitTemplate.convertAndSend("headersExchange", "", message);
//    }
//
//    public void sendHeadersExchange02(String msg) {
//        log.info("发送消息(headersQUEUE01接收)：" + msg);
//        MessageProperties properties = new MessageProperties();
//        properties.setHeader("color", "red");
//        properties.setHeader("speed", "normal");
//        Message message = new Message(msg.getBytes(), properties);
//        rabbitTemplate.convertAndSend("headersExchange", "", message);
//    }
}
