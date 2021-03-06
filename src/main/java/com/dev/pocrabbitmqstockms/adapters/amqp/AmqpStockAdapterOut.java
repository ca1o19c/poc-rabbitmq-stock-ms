package com.dev.pocrabbitmqstockms.adapters.amqp;

import com.dev.pocrabbitmqstockms.application.ports.AmqpPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
class AmqpStockAdapterOut implements AmqpPort {

    private final RabbitTemplate rabbitTemplate;

    AmqpStockAdapterOut(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void notifyUpdateStock(String queueName, Object message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }
}
