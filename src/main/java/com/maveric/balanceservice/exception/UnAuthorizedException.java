package com.maveric.balanceservice.exception;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException(String message) {
        super(message);
    }
}
