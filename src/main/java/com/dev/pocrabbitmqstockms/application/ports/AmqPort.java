package com.dev.pocrabbitmqstockms.application.ports;

public interface AmqPort {
    void notifyUpdateStock(String queueName, Object message);
}
