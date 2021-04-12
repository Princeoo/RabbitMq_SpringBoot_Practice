package com.princeoo.rabbitmq_springboot.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/11 8:05 下午
 * @Description:
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange" , type = ExchangeTypes.TOPIC),
        key = "*.email.#"
))
public class TopicEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("email fanout --- 接收到了邮件信息是：->" + message);
    }
}
