package springboot.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiReportSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void generateReports(String msg){
        //Fanout Exchange 消息广播的模式，不管路由键或者是路由模式，会把消息发给绑定给它的全部队列，如果配置了 routing_key 会被忽略。
        rabbitTemplate.convertAndSend("reportExchange", "api.generate.reports", msg);
    }
}