package com.dev.pocrabbitmqstockms.adapters.http;

import com.dev.pocrabbitmqstockms.adapters.dtos.StockSerializer;
import com.dev.pocrabbitmqstockms.application.ports.AmqPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poc/v1/stocks")
class HttpStockAdapter {

    private final AmqPort amqPort;
    private static final String QUEUE_STOCK = "STOCK";

    HttpStockAdapter(AmqPort amqPort) {
        this.amqPort = amqPort;
    }

    @PutMapping
    private ResponseEntity updateStock(@RequestBody StockSerializer stock) {
        System.out.println(stock.getStockId());
        this.amqPort.notifyUpdateStock(QUEUE_STOCK, stock);
        return new ResponseEntity(HttpStatus.OK);
    }
}
