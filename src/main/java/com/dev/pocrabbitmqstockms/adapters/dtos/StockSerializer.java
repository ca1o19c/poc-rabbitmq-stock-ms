package com.dev.pocrabbitmqstockms.adapters.dtos;

import java.io.Serializable;

public class StockSerializer implements Serializable {
    private String stockId;
    private int amount;

    public String getStockId() {
        return stockId;
    }

    public StockSerializer setStockId(String stockId) {
        this.stockId = stockId;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public StockSerializer setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
