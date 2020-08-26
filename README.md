# Um pouco do fluxo do ActiveMQ para utiliza-lo em Producer/Consumer
![image](https://user-images.githubusercontent.com/68428764/91353769-1b8b3100-e7c2-11ea-958e-e27ce354b35f.png)

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
