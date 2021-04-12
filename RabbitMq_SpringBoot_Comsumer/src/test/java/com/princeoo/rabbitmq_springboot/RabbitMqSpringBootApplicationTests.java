package com.princeoo.rabbitmq_springboot;

import com.princeoo.rabbitmq_springboot.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMqSpringBootApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }

}
