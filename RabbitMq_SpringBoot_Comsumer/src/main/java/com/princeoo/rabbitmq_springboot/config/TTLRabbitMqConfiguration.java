package com.princeoo.rabbitmq_springboot.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/10 3:49 下午
 * @Description: 配置类哪边定义都可以 如果是生产者定义的话 消费者没找到这个队列会报错
 */
@Configuration
public class TTLRabbitMqConfiguration {

    //1.声明注册Direct模式的交换机
    @Bean
    public DirectExchange TTLdirectExchange(){
        return new DirectExchange("ttl_direct_exchange",true,false);
    }


    //2.声明队列 sms.Direct.queue email.Direct.queue duanxin.Direct.queue
    @Bean
    public Queue TTLdirectQueue(){
        //设置过期时间
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000);
        return new Queue("ttl.Direct.queue",true,false,false,args);
    }

    @Bean
    public Queue TTLdirectMssageQueue(){
        //设置过期时间
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000);
        args.put("x-dead-letter-exchange","dead_direct_exchange");
        args.put("x-dead-letter-routing-key","dead");//fanout不需要配置
        return new Queue("ttl.message.Direct.queue",true,false,false,args);
    }

    @Bean
    public Binding directTtlBinding(){
        return BindingBuilder.bind(TTLdirectQueue()).to(TTLdirectExchange()).with("ttl");
    }

    @Bean
    public Binding directTtlMessageBinding(){
        return BindingBuilder.bind(TTLdirectMssageQueue()).to(TTLdirectExchange()).with("ttlmessage");
    }
}
