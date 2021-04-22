package com.cts.card.exception;

/**
 * Exception class 400
 */
public class BadRequestException extends RuntimeException {

    BadRequestException(String message) {
        super(message);
    }
}
