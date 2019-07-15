package springboot.rabbitmq.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hahaha
 * 添加一个user()方法，发送消息至coreExchange交换机且routingKey为api.core.user
 * 添加一个userQuery()方法，发送消息至coreExchange交换机且routingKey为api.core.user.query
 */
@Component
public class ApiCoreSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg){
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}