package com.example.coursework.Exception;

public class StorageEmptyException extends RuntimeException {
    public StorageEmptyException() {
    }

    public StorageEmptyException(String message) {
        super(message);
    }

    public StorageEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageEmptyException(Throwable cause) {
        super(cause);
    }

    public StorageEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}