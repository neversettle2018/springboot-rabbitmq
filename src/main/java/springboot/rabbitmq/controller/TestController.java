package springboot.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.rabbitmq.provider.ApiCoreSender;
import springboot.rabbitmq.provider.ApiPaymentSender;
import springboot.rabbitmq.provider.ApiReportSender;
import springboot.rabbitmq.provider.PaymentNotifySender;

@RestController
public class TestController {

    @Autowired
    private PaymentNotifySender paymentNotifySender;

    @Autowired
    private ApiPaymentSender apiPaymentSender;

    @Autowired
    private ApiCoreSender apiCoreSender;

    @Autowired
    private ApiReportSender apiReportSender;



    @RequestMapping("testDirect")
    public void  testDirect(){
        paymentNotifySender.sender("支付订单号："+System.currentTimeMillis());
    }


    @RequestMapping("testTopic")
    public void  testTopic(){
        apiCoreSender.user("user");
        apiCoreSender.userQuery("user query");

        apiPaymentSender.order("order");
        apiPaymentSender.orderDetailQuery("orderDetailQuery");
        apiPaymentSender.orderQuery("query");


    }


    @RequestMapping("testFanout")
    public void  testFanout(){
        apiReportSender.generateReports("接收到报表");
    }



}
