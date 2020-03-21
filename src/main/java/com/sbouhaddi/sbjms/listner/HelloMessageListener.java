/**
 * 
 */
package com.sbouhaddi.sbjms.listner;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
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
public class HelloMessageListener {
	
	private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsCOnfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

//        System.out.println("I Got a Message!!!!!");
//
//        System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
       //throw new RuntimeException("foo");

    }

    
    @JmsListener(destination = JmsCOnfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message jmsMessage,
                               org.springframework.messaging.Message springMessage) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        //example to use Spring Message type
       // jmsTemplate.convertAndSend((Destination) springMessage.getHeaders().get("jms_replyTo"), "got it!");

        jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), payloadMsg);

    }
}
