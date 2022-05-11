package com.example.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfig {

    static final String exchangeName = "spring-boot-exchange";

    @Bean
    Queue queue() {
        return new AnonymousQueue();
        //return new Queue(queueName, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.*");
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, Queue queue) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(queue);
        simpleMessageListenerContainer.setMessageListener(new Receiver());
        return simpleMessageListenerContainer;
    }
}
