/**
 * 
 */
package com.sbouhaddi.sbjms.listner;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sbouhaddi.sbjms.config.JmsCOnfig;
import com.sbouhaddi.sbjms.model.HelloWorldMessage;

/**
 * @author bouhaddisabri
 *
 */
@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsCOnfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I Got a Message!!!!!");

        System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
       //throw new RuntimeException("foo");

    }

}
