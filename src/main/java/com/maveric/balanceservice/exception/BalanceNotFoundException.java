package com.maveric.balanceservice.exception;

public class BalanceNotFoundException extends RuntimeException{
    public BalanceNotFoundException(String message) {
        super(message);
    }
}
