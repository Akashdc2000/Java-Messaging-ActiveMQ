package com.messaging.messagingactivemq;

import javax.jms.*;


import org.apache.activemq.ActiveMQConnectionFactory;


public class RecieveMessageFromQueue {

    public void recieveMessage() throws JMSException{

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a connection
        Connection connection = factory.createConnection();

        // Start the connection
        connection.start();

        // Create a session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


        // Create a queue
        Queue queue = session.createQueue("MyQueue");


        // Create a consumer
        MessageConsumer consumer = session.createConsumer(queue);

        Message receivedMessage = consumer.receive();

        System.out.println("==================================================================");
        System.out.println("Received message: " + ((TextMessage)receivedMessage).getText());
        System.out.println("==================================================================");



        connection.close();

    }

}
