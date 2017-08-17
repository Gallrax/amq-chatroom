package com.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/8/4
 * @Version: 1.0
 */
@Service
public class ProducerService {

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
        System.out.println(" Send Message : "+ message +" to Destination : "+ destination.toString());
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        jmsTemplate.send(destination,messageCreator);
    }

    public void sendMessage(final String message) {
        String destination = jmsTemplate.getDefaultDestinationName();
        System.out.println(" Send Message : "+ message +" to Destination : "+ destination.toString());
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        jmsTemplate.send(messageCreator);
    }
}
