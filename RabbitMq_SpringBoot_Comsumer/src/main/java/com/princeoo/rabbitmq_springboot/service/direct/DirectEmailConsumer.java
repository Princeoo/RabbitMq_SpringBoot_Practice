package com.princeoo.rabbitmq_springboot.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/11 8:05 下午
 * @Description:
 */
@Service
@RabbitListener(queues = {"email.Direct.queue"})
public class DirectEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("duanxin fanout --- 接收到了邮件信息是：->" + message);
    }
}
