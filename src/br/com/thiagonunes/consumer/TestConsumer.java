package br.com.thiagonunes.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TestConsumer {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destino = (Destination) context.lookup("financeiro");

        MessageConsumer messageConsumer = session.createConsumer(destino);

        Message message = messageConsumer.receive();

        System.out.println("Mensagem recebida: " + message);

        new Scanner(System.in).nextLine();

        connection.close();
        context.close();
    }
}
