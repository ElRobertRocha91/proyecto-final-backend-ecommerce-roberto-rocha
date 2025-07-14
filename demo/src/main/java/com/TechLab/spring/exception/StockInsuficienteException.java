package com.TechLab.spring.exception;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String message) {
        super(message);
    }
}
