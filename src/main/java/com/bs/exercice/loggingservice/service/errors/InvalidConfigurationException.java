package com.bs.exercice.loggingservice.service.errors;

public class InvalidConfigurationException extends RuntimeException {

    public static final String INVALID_CONFIGURATION_EXCEPTION_MESSAGE = "Invalid configuration";

    public InvalidConfigurationException() {
        super(INVALID_CONFIGURATION_EXCEPTION_MESSAGE);
    }
}