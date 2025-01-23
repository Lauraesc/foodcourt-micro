package com.foodcourt.foodcourtmicro.domain.exception;

public class NitAlreadyExistsException extends RuntimeException {
    public NitAlreadyExistsException(String message) {
        super(message);
    }
}
