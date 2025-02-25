package com.montreal.storage.api.domain.exceptions;

public class InternalErrorException extends RuntimeException {

    public InternalErrorException(String message, Throwable e) {
        super(message, e);
    }

}
