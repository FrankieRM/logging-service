package com.bs.exercice.loggingservice.service.errors;

public class NullLevelNameException extends RuntimeException {

    public static final String NULL_LEVEL_NAME_EXCEPTION_MESSAGE = "The field levelName is required";

    public NullLevelNameException() {
        super(NULL_LEVEL_NAME_EXCEPTION_MESSAGE);
    }
}