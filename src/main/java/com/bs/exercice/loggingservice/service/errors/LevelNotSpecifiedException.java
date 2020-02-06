package com.bs.exercice.loggingservice.service.errors;

public class LevelNotSpecifiedException extends RuntimeException {

    public static final String LEVEL_NOT_SPECIFIED_EXCEPTION_MESSAGE = "Error or Warning or Message must be specified";

    public LevelNotSpecifiedException() {
        super(LEVEL_NOT_SPECIFIED_EXCEPTION_MESSAGE);
    }
}