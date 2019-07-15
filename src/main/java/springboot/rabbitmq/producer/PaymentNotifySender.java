package springboot.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hahaha
 * 将消息发送至默认的交换机且routingKey为notify.payment
 */
@Component
public class PaymentNotifySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}