package br.com.thiagonunes.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.Scanner;

public class TestConsumer {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();

        properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.setProperty("java.naming.provider.url", "tcp://localhost:61616");
        properties.setProperty("queue.financeiro", "fila.financeiro");

        InitialContext context = new InitialContext(properties);

        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destino = (Destination) context.lookup("financeiro");

        MessageConsumer messageConsumer = session.createConsumer(destino);

        messageConsumer.setMessageListener(new MessageConsumerListener());

        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
    }
}
