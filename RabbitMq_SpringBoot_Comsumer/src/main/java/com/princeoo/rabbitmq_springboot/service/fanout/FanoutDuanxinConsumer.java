package com.princeoo.rabbitmq_springboot.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/11 8:05 下午
 * @Description:
 */
@Service
@RabbitListener(queues = {"duanxin.fanout.queue"})
public class FanoutDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("duanxin fanout --- 接收到了订单信息是：->" + message);
    }

}
