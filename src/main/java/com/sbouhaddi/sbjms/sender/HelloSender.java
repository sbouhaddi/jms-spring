/**
 * 
 */
package com.sbouhaddi.sbjms.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sbouhaddi.sbjms.config.JmsCOnfig;
import com.sbouhaddi.sbjms.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

/**
 * @author bouhaddisabri
 *
 */
@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        System.out.println("I'm Sending a message");

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();

        jmsTemplate.convertAndSend(JmsCOnfig.MY_QUEUE, message);

        System.out.println("Message Sent!");

    }

}
