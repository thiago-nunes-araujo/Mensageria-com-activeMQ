# Mensageria-com-activeMQ
Intuito deste repositório é armazenar conteúdo aprendido sobre mensageria com ActiveMQ.

# Consumir todas mensagens recebidas
 Vamos modificar nosso consumer atual para ouvir todas e qualquer mensagem recebida como a seguir:
 ```
 de:
    Message message = messageConsumer.receive();
    System.out.println("Mensagem recebida: " + message);
 para:
    messageConsumer.setMessageListener(new MessageConsumerListener());
 ```
  agora passamos a ouvir sem para qualquer mensagem enviada ao nosso ActiveMQ.
