package com.princeoo.rabbitmq_springboot.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xiaoJie
 * @Date: 2021/4/10 3:49 下午
 * @Description: 配置类哪边定义都可以 如果是生产者定义的话 消费者没找到这个队列会报错
 */
@Configuration
public class DirectRabbitMqConfiguration {

    //1.声明注册Direct模式的交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("Direct_order_exchange",true,false);
    }
    //2.声明队列 sms.Direct.queue email.Direct.queue duanxin.Direct.queue
    @Bean
    public Queue directsmsQueue(){
        return new Queue("sms.Direct.queue",true);
    }

    @Bean
    public Queue directduanxinQueue(){
        return new Queue("duanxin.Direct.queue",true);
    }

    @Bean
    public Queue directemailQueue(){
        return new Queue("email.Direct.queue",true);
    }
    //3.完成绑定关系（队列和交换机完成绑定关系）
    @Bean
    public Binding directsmsBinding(){
        return BindingBuilder.bind(directsmsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding directemailBinding(){
        return BindingBuilder.bind(directemailQueue()).to(directExchange()).with("email");
    }

    @Bean
    public Binding directduanxinBinding(){
        return BindingBuilder.bind(directduanxinQueue()).to(directExchange()).with("duanxin");
    }
}
