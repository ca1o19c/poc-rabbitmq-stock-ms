package com.dev.pocrabbitmqstockms.application.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RabbitMqConnection {

    private static final String EXCHANGE_NAME = "amq.direct";
    private static final String QUEUE_STOCK = "STOCK";

    private AmqpAdmin amqpAdmin;

    public RabbitMqConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding binding(Queue queue, DirectExchange directExchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,
                directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add() {
        var stockQueue = this.queue(QUEUE_STOCK);
        var directExchange = this.directExchange();
        var binding = this.binding(stockQueue, directExchange);

        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(binding);
    }
}
