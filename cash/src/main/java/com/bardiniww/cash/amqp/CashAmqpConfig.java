package com.bardiniww.cash.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CashAmqpConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.cash}")
    private String cashQueue;

    @Value("${rabbitmq.routing-keys.internal-cash}")
    private String internalCashRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue cashQueue() {
        return new Queue(this.cashQueue);
    }

    @Bean
    public Binding internalToCashBinding() {
        return BindingBuilder
                .bind(cashQueue())
                .to(internalTopicExchange())
                .with(this.internalCashRoutingKey);
    }


    public String getInternalExchange() {
        return internalExchange;
    }

    public String getCashQueue() {
        return cashQueue;
    }

    public String getInternalCashRoutingKey() {
        return internalCashRoutingKey;
    }
}
