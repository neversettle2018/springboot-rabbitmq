package springboot.rabbitmq.consumber;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hahaha
 * 添加payment()方法，监听routingKey为api.report.payment的队列消息
 * 添加refund()方法，监听routingKey为api.report.refund的队列消息
 */
@Component
public class ApiReportReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.report.payment")
    public void payment(String msg) {
        System.out.println("api.report.payment receive message: " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "api.report.refund")
    public void refund(String msg) {
        System.out.println("api.report.refund receive message: " + msg);
    }

}