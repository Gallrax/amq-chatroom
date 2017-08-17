package com.test;

import com.service.ConsumerService;
import com.service.ProducerService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import javax.jms.Destination;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/8/4
 * @Version: 1.0
 */
public class TestMessage {

    ApplicationContext applicationContext;
    ProducerService producerService;
    ConsumerService consumerService;
    Destination destination;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        producerService = applicationContext.getBean(ProducerService.class);
        consumerService = applicationContext.getBean(ConsumerService.class);
        destination = applicationContext.getBean(Destination.class);
        System.out.println(destination.toString());
    }

    @Test
    public void test01() {
        producerService.sendMessage(destination, " Hello World !");
    }

    @Test
    public void test02() {
        consumerService.receive(destination);
    }

}
