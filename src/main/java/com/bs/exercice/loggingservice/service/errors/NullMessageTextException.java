package com.bs.exercice.loggingservice.service.errors;

public class NullMessageTextException extends RuntimeException {

    public static final String NULL_MESSAGE_TEXT_EXCEPTION_MESSAGE = "The field messageText is required";

    public NullMessageTextException() {
        super(NULL_MESSAGE_TEXT_EXCEPTION_MESSAGE);
    }
}