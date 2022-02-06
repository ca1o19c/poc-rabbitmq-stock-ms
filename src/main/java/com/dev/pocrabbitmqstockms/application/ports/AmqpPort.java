package com.dev.pocrabbitmqstockms.application.ports;

public interface AmqpPort {
    void notifyUpdateStock(String queueName, Object message);
}
