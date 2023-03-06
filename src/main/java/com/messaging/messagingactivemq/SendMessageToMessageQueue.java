package com.messaging.messagingactivemq;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
public class SendMessageToMessageQueue {

    public void sendMessage(String msg) throws JMSException
    {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a connection
        Connection connection = factory.createConnection();

        // Start the connection
        connection.start();

        // Create a session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue
        Queue queue = session.createQueue("MyQueue");

        // Create a producer
        MessageProducer producer = session.createProducer(queue);

        // Create a message
        TextMessage message = session.createTextMessage(msg);

        // Send the message
        producer.send(message);

        System.out.println("Message sent to the ActiveMQ Queue...");


        // Close the connection
        connection.close();

    }
}
