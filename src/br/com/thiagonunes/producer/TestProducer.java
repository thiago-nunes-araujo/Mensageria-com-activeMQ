package br.com.thiagonunes.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.Scanner;

public class TestProducer {

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

        Destination fila = (Destination) context.lookup("financeiro");

        MessageProducer producer = session.createProducer(fila);

        for (int i = 0; i < 55; i++){
            Message message = session.createTextMessage("Mensagem numero: " + i);
            producer.send(message);
        }

        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
    }
}
