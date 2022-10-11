package com.maveric.balanceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BalanceNotFoundException extends RuntimeException{
        public BalanceNotFoundException(String message) {
            super(message);
        }
    }


