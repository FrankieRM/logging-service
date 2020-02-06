package com.bs.exercice.loggingservice.service.errors;

public class LevelDisabledException extends RuntimeException {

    public static final String LEVEL_DISABLED_EXCEPTION_MESSAGE = "The specified level is disabled in configuration";

    public LevelDisabledException() {
        super(LEVEL_DISABLED_EXCEPTION_MESSAGE);
    }
}