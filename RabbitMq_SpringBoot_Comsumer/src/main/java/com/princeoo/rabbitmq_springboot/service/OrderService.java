package com.princeoo.rabbitmq_springboot.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/10 3:24 下午
 * @Description:
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * @param userid
     * @param productid
     * @param num
     */
    public void makeOrder(String userid, String productid, int num) {
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功:" + orderId);
        //3.通过mq来完成消息的分发
        //参数：交换机    路由key/queue队列名称 消息内容
        String exangeName = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exangeName, routingKey, orderId);
    }
}
