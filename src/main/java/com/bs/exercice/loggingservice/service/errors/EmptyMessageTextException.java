package com.bs.exercice.loggingservice.service.errors;

public class EmptyMessageTextException extends RuntimeException {

    public static final String EMPTY_MESSAGE_TEXT_EXCEPTION_MESSAGE = "The field messageText is empty";

    public EmptyMessageTextException() {
        super(EMPTY_MESSAGE_TEXT_EXCEPTION_MESSAGE);
    }
}