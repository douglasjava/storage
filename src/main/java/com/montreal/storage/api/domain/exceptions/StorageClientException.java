package com.montreal.storage.api.domain.exceptions;

public class StorageClientException extends RuntimeException {

    public StorageClientException(String message) {
        super(message);
    }

    public StorageClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
