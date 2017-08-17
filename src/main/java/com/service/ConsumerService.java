package com.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/8/4
 * @Version: 1.0
 */
@Service
public class ConsumerService {

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination) {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        if (textMessage != null) {
            try {
                String text = textMessage.getText();
                String destinationName = destination.toString();
                System.out.println(" Get Message : " + text + " from Destination : " + destinationName);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return textMessage;
    }
}
