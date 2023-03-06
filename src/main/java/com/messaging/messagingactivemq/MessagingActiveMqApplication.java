package com.messaging.messagingactivemq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;

import java.util.Scanner;

@SpringBootApplication
public class MessagingActiveMqApplication {

    public static void main(String[] args) throws JMSException{
        SpringApplication.run(MessagingActiveMqApplication.class, args);

        Scanner sc=new Scanner(System.in);
        SendMessageToMessageQueue send=new SendMessageToMessageQueue();

        System.out.print("Enter message to send:");
        String msg=sc.nextLine();
        send.sendMessage(msg);

        RecieveMessageFromQueue receive=new RecieveMessageFromQueue();
        receive.recieveMessage();
    }

}
