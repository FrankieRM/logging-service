package com.bs.exercice.loggingservice.service.errors;

public class WrongFilePathException extends RuntimeException {

    public static final String WRONG_FILE_PATH_EXCEPTION_MESSAGE = "The file path is wrong";

    public WrongFilePathException(Throwable cause) {
        super(WRONG_FILE_PATH_EXCEPTION_MESSAGE, cause);
    }
}