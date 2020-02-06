package com.bs.exercice.loggingservice.service.errors;

public class EmptyLevelNameException extends RuntimeException {

    public static final String EMPTY_LEVEL_NAME_EXCEPTION_MESSAGE = "The field levelName is empty";

    public EmptyLevelNameException() {
        super(EMPTY_LEVEL_NAME_EXCEPTION_MESSAGE);
    }
}