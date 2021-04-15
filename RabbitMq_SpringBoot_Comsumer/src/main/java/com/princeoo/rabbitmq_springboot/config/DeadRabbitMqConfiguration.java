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
public class DeadRabbitMqConfiguration {

    //1.声明注册direct模式的交换机
    @Bean
    public DirectExchange deadDirect(){
        return new DirectExchange("dead_direct_exchange",true,false);}
    //    //2.队列的过期时间
    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue", true);
    }

    @Bean
    public Binding deadbinds(){
        return BindingBuilder.bind(deadQueue()).to(deadDirect()).with("dead");
    }
}
