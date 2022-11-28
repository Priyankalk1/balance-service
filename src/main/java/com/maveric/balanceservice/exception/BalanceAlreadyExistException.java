package com.maveric.balanceservice.exception;

public class BalanceAlreadyExistException extends RuntimeException{
    public BalanceAlreadyExistException(String message) {
        super(message);
    }
}
